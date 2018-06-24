package com.hwua.crs.client.view;

import com.alibaba.fastjson.JSON;
import com.hwua.crs.client.entity.Car;
import com.hwua.crs.client.entity.Record;
import com.hwua.crs.client.entity.User;
import com.hwua.crs.client.util.InfoValue;
import com.hwua.crs.client.util.InputUtil;
import com.hwua.crs.client.util.SqlUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserInterfaceView extends AbstractUserView {
    private Lock lock = new ReentrantLock();
    public UserInterfaceView(User user) {
        super(user);
        this.initialization();
    }
    private void initialization () {
        System.out.println("=========================》》》用户界面");
        System.out.println("欢迎"+user.getUsername());
        this.major();
    }
    private void major () {
        System.out.println("1.查询所有汽车");
        System.out.println("2.租一辆车");
        System.out.println("3.还一辆车");
        System.out.println("4.查看租车记录");
        System.out.println("Rest.退出! ");
        System.out.print("\n请输入你的选择(1~4)：");
        switch (InputUtil.next()) {
            case "1":
                this.queryCarAll();
                this.queryCar();
                break;
            case "2":
                this.carRenting();
                this.major();
                break;
            case "3":
                this.returnCar();
                this.major();
                break;
            case "4":
                this.showRecord(this.queryRecordAll());
                this.queryRecord();
                break;
            default:
                System.exit(0);
        }
    }
    private void carRenting () {
        System.out.println("请输入需要租赁的车辆编号：");
        long carId = InputUtil.nextLong();
        this.carRenting(carId);
    }
    private void carRenting (long carId) {
        Car car = queryCar(carId);
        if (car == null) {
            System.out.println("车辆不存在");
            return;
        }
        if (car.getStatus() == 0) {
            lock.lock();
            try {
                this.renting(carId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }else {
            System.out.println("该车已经被别人租了!");
        }
    }
    private void renting (long carId) {
        Car car = queryCar(carId);
        if (car.getStatus() == 0) {
            //租车行动
            String sql = "INSERT INTO t_record(start_date,return_date,payment,id,user_id,car_id) " +
                    "VALUES (to_date(?,'yyyy-mm-dd hh24:mi:ss'),null,0,t_record_id_seq.nextval,?,?)";
            String sqlII = "UPDATE t_car SET status = 1 WHERE id = ?";

            sql = SqlUtil.doubleUpdate(sql,InfoValue.RECORD,sqlII,InfoValue.CAR);
            String time = SqlUtil.getTime();
            Record record = new Record(user.getId(),carId,time);
            car = new Car(carId);
            int result = Integer.parseInt(sqlLink(sql,record,car));
            if(result == 2) {
                System.out.println("租车成功");
                this.showCarRentingInfo(this.queryRecord(carId,time));
            }else {
                System.out.println("租车失败");
            }
        }else {
            System.out.println("手快有,手慢无,该车已经别人抢先租走了!");
            System.out.println("换一辆车租吧!");
        }
    }
    private void returnCar () {
        System.out.println("请输入需要归还的车辆编号：");
        long carId = InputUtil.nextLong();
        this.returnCar(carId);
    }
    private void returnCar (long carId) {
        Car car = queryCar(carId);
        if (car == null) {
            System.out.println("车辆不存在");
            return;
        }
        if (car.getStatus() == 1) {
            String sql = InfoValue.QUERY_RECORD+"WHERE return_date is null AND user_id = ? AND car_id = ?";
            Record record = new Record(user.getId(),carId);
            Record recordII = getRecord(this.queryRecord(sql,record));
            if (recordII != null) {
                //还车
                this.returnCar(carId,recordII,car.getRent());
            }else {
                System.out.println("该车不是你租的哦");
            }
        }else {
            System.out.println("该车没有被租,或者你已经还过了哦");
        }
    }
    private void returnCar(long carId,Record recordII,double rent) {
        String sql = "UPDATE t_record SET return_date = to_date(?,'yyyy-mm-dd hh24:mi:ss'),payment = ? WHERE id = ?";
        String sqlII = "UPDATE t_car SET status = 0 WHERE id = ?";
        Timestamp d1 = SqlUtil.strToSqlDate(recordII.getStartDate());
        Timestamp time = SqlUtil.getTimestamp();
        long diff = d1.getTime() - time.getTime();
        //天
        long days = diff / (1000 * 60 * 60 * 24);
        //时
        long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
        //分
        long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
        double money =  (days+1)*rent;

        sql = SqlUtil.doubleUpdate(sql,InfoValue.RECORD,sqlII,InfoValue.CAR);
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
        System.out.println("time"+str);
        Record record = new Record(recordII.getId(),str,money);
        Car car = new Car(carId);
        int result = Integer.parseInt(sqlLink(sql,record,car));
        if(result == 2) {
            System.out.println("还车成功");
            this.showCarReturnInfo(this.queryRecord(recordII.getId()));
        }else {
            System.out.println("还车失败");
        }
    }
    private void queryCarAll () {
        String sql = "SELECT * FROM t_car WHERE useable = 0 ORDER BY id ASC";
        this.showCar(this.queryCar(sql));
    }
    private void queryCar () {
        System.out.println("1.查看全部汽车");
        System.out.println("2.价格降序排序");
        System.out.println("3.价格升序排序");
        System.out.println("4.查看我的租车记录");
        System.out.println("5+ 品牌编号 按品牌搜索");
        System.out.println("6+ 类型编号 按类型搜索");
        System.out.println("7+ 汽车编号 进行租车");
        System.out.println("8+ 汽车编号 进行还车");
        String[] str = InputUtil.next().split("\\+");

        String choose = str[0];
        switch (choose) {
            case "1":
                //查询全部汽车
                this.queryCarAll();
                break;
            case "2":
                //价格降序排序
                String sql = "SELECT * FROM t_car WHERE useable = 0 ORDER BY rent DESC";
                this.showCar(this.queryCar(sql));
                break;
            case "3":
                //价格升序排序
                sql = "SELECT * FROM t_car WHERE useable = 0 ORDER BY rent ASC";
                this.showCar(this.queryCar(sql));
                break;
            case "4":
                //查看我的租车记录
                this.showRecord(this.queryRecordAll());
                break;
            case "5":
                //按品牌搜索
                sql = "SELECT * FROM t_car WHERE useable = 0  AND brand_id = ?";
                Car car = new Car(Long.parseLong(str[1]));
                this.showCar(this.queryCar(sql,car));
                break;
            case "6":
                //按类型搜索
                sql = "SELECT * FROM t_car WHERE useable = 0  AND category_id = ?";
                car = new Car(Long.parseLong(str[1]));
                this.showCar(this.queryCar(sql,car));
                break;
            case "7":
                //按汽车编号进行租车
                this.carRenting(Long.parseLong(str[1]));
                break;
            case "8":
                //按汽车编号进行还车
                this.returnCar(Long.parseLong(str[1]));
                break;
            default:
                this.major();
                break;
        }
        this.queryCar();
    }
    private Car queryCar(long id) {
        String sql = "SELECT * FROM t_car WHERE useable = 0 AND id = ?";
        Car car =  new Car(id);
        return getCar(queryCar(sql,car));
    }
    @Override
    public List<Car> queryCar(String sql, Car car) {
        return JSON.parseArray(this.sqlLink(SqlUtil.querySql(sql,InfoValue.CAR),car),Car.class);
    }
    private List<Car> queryCar(String sql) {
        return queryCar(sql,null);
    }
    private List<Record> queryRecordAll() {
        String sql = InfoValue.QUERY_RECORD+" WHERE user_id = ?";
        Record record = new Record(user.getId());
        return this.queryRecord(sql,record);

    }
    private void queryRecord () {
        System.out.println("1.查看全部汽车");
        System.out.println("2.查看我的租赁记录");
        System.out.println("3+ 汽车编号还车");
        System.out.println("Rest.返回主界面");

        String[] str = InputUtil.next().split("\\+");

        String choose = str[0];

        switch (choose) {
            case "1":
                //查询全部汽车(默认id升序)
                this.showCar(this.carUpdate());
                this.queryCar();
                return;
            case "2":
                //查看我的租赁记录
                this.showRecord(this.queryRecordAll());
                break;
            case "3":
                //按汽车编号还车
                this.returnCar(Long.parseLong(str[1]));
                break;
            default:
                this.major();
                break;
        }
        this.queryRecord();
    }
    private Record queryRecord (long id) {
        String sql = InfoValue.QUERY_RECORD+" WHERE id = ?";
        Record record = new Record(id);
        return getRecord(this.queryRecord(sql,record));
    }
    private Record queryRecord (long carId,String time) {
        String sql = InfoValue.QUERY_RECORD+" WHERE start_date = to_date(?,'yyyy-mm-dd hh24:mi:ss') AND user_id = ? AND car_id = ?";
        Record record = new Record(user.getId(),carId,time);
        return getRecord(this.queryRecord(sql,record));
    }
    @Override
    public List<Record> queryRecord(String sql,Record record) {
        return JSON.parseArray(sqlLink(SqlUtil.querySql(sql,InfoValue.RECORD),record),Record.class);
    }
    private void showCarReturnInfo (Record record) {
        this.carUpdate();
        System.out.println("============================================================================================================================================");
        System.out.println("编号\t汽车名称   每日租金\t 租金总额       备注\t\t品牌   \t 类型   \t\t借车时间 \t\t\t\t还车时间");
        if (record != null) {
            Car car = carMap.get(record.getCarId());
            System.out.printf("%-4s"," "+record.getId());
            System.out.printf("%-10s"," "+car.getModel());
            System.out.printf("%-10s",car.getRent()+"/天");
            System.out.printf("%-10s"," "+record.getPayment());
            System.out.printf("%-10s","\t"+car.getComments());
            System.out.printf("%-8s","\t"+brandMap.get(car.getBrandId()).getName());
            System.out.printf("%-8s",carCategoryMap.get(car.getCategoryId()).getName());
            System.out.printf("%-25s","\t"+record.getStartDate());
            System.out.printf("%-15s",record.getReturnDate());
            System.out.println();
        }
    }
    private void showCarRentingInfo (Record record) {
        this.carUpdate();
        System.out.println("===================================================================================" +
                "=========================================================");
        System.out.println("编号\t汽车名称\t   每日租金    备注\t\t品牌   \t 类型   \t\t借车时间");
        if (record != null) {
            Car car = carMap.get(record.getCarId());
            System.out.printf("%-4s"," "+record.getId());
            System.out.printf("%-10s"," "+car.getModel());
            System.out.printf("%-10s","  "+car.getRent());
            System.out.printf("%-10s",car.getComments());
            System.out.printf("%-8s","\t"+brandMap.get(car.getBrandId()).getName());
            System.out.printf("%-8s",carCategoryMap.get(car.getCategoryId()).getName());
            System.out.printf("%-25s","\t"+record.getStartDate());
            System.out.println();
        }
    }
    @Override
    public void showCar(List<Car> carList) {
        System.out.println("==========================================================================================================");
        System.out.println("编号  \t汽车名称  \t\t  备注 \t\t\t 品牌  \t\t\t  类型\t\t\t价格 \t\t是否可租");
        if (carList != null)
        {
            for (Car obj : carList) {
                System.out.printf("%-8s"," "+obj.getId());
                System.out.printf("%-10s",obj.getModel());
                System.out.printf("%-13s","   \t"+obj.getComments());
                System.out.printf("%-13s","   \t"+brandMap.get(obj.getBrandId()).getName()+"("+obj.getBrandId()+")");
                System.out.printf("%-13s","   \t"+carCategoryMap.get(obj.getCategoryId()).getName()+"("+obj.getCategoryId()+")");
                System.out.printf("%-16s","   \t"+obj.getRent()+"/天");
                System.out.printf("%-8s",(obj.getStatus()==0)?"可借":"不可借");
                System.out.println();
            }
        }
    }
    @Override
    public void showRecord(List<Record> recordList) {
        this.userUpdate();
        this.carUpdate();
        System.out.println("============================================================================================================================================");
        System.out.println("编号\t汽车编号\t汽车名称\t   租金总额       备注\t\t品牌   \t 类型   \t\t借车时间 \t\t\t\t还车时间");
        if (recordList != null) {
            for (Record obj: recordList) {
                Car car = carMap.get(obj.getCarId());
                System.out.printf("%-4s"," "+obj.getId());
                System.out.printf("%-8s","  "+car.getId());
                System.out.printf("%-10s"," "+car.getModel());
                System.out.printf("%-10s","\t"+(obj.getReturnDate() == null?"未归还":obj.getPayment()));
                System.out.printf("%-10s","\t"+car.getComments());
                System.out.printf("%-8s","\t"+brandMap.get(car.getBrandId()).getName());
                System.out.printf("%-8s",carCategoryMap.get(car.getCategoryId()).getName());
                System.out.printf("%-25s","\t"+obj.getStartDate());
                System.out.printf("%-15s",obj.getReturnDate() == null?"未归还":obj.getReturnDate());
                System.out.println();
            }
        }
    }
}
