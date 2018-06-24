package com.hwua.crs.client.view;

import com.alibaba.fastjson.JSON;
import com.hwua.crs.client.entity.*;
import com.hwua.crs.client.util.Excel;
import com.hwua.crs.client.util.InfoValue;
import com.hwua.crs.client.util.InputUtil;
import com.hwua.crs.client.util.SqlUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yoSakura
 * @Date: 2018/6/14 15:31
 */
public class AdminView extends AbstractUserView{
    public AdminView(User user){
        super(user);
        this.initialization();
    }
    private void initialization () {
        System.out.println("=========================》》》管理员界面");
        System.out.println("   欢迎"+this.user.getUsername());
        this.major();
    }
    private void major () {
        System.out.println("\n1.查询汽车");
        System.out.println("2.添加汽车");
        System.out.println("3.修改汽车");
        System.out.println("4.查询租赁记录");
        System.out.println("5.Excel操作! ");
        System.out.println("6.返回主界面! ");
        System.out.println("Rest.退出! ");
        System.out.print("\n请输入你的选择(1~5)：");

        switch (InputUtil.next()) {
            case "1":
                //查询汽车
                this.queryCar();
                break;
            case "2":
                //添加汽车
                this.addCar();
                this.major();
                break;
            case "3":
                //修改汽车
                this.updateCar();
                this.major();
                break;
            case "4":
                //查询租赁记录
                this.queryRecord();
                break;
            case "5":
                //excel操作
                this.excel();
                this.major();
                break;
            case "6":
                //返回主界面
                new StartView().start();
                break;
            default:
                //退出
                System.exit(0);
        }
    }
    public void excel () {
        System.out.println("\n1.导入汽车信息Excel");
        System.out.println("2.导出汽车信息Excel");
        switch (InputUtil.next()) {
            case "1":
                String path = "excel\\汽车信息表.xls";
                this.importCar(path);
                break;
            case "2":
                path = "excel\\汽车信息表.xls";
                this.outCar(path);
                break;
                default:
                    break;
        }
    }
    public void importCar (String path) {
        try {
            List<Car> carList = Excel.getWork(path);
            System.out.println(carList.get(0).getId());
            String sql = "INSERT INTO t_car(rent,status,useable,id,car_number,brand_id,model,color,category_id,t_comments,price)" +
            " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            System.out.println(this.sqlLink(SqlUtil.excelUpdate(sql),carList));
            System.out.println("导入成功");
        } catch (IOException e) {
            System.out.println("导入失败");
            e.printStackTrace();
        }
    }
    public void outCar(String path) {
        try {
            Excel.outCar(path,this.carUpdate());
            System.out.println("导出成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("导出错误!");
        }

    }

    /**
     * 查询主界面
     */
    private void queryCar () {
        System.out.println("\n1.查询全部汽车(默认id升序)");
        System.out.println("2.按价格降序排序");
        System.out.println("3.按价格升序排序");
        System.out.println("4.添加汽车");
        System.out.println("5.查询租赁记录 ");
        System.out.println("6+ 汽车编号 查看指定汽车");
        System.out.println("7+ 类型编号 按类型搜索");
        System.out.println("8+ 品牌编号 按品牌搜索");
        System.out.println("9+ 汽车编号 修改汽车信息");
        System.out.println("Rest.返回上一层");

        String[] str = InputUtil.next().split("\\+");
        String sql;
        String choose = str[0];

        switch (choose) {
            case "1":
                //查询全部汽车(默认id升序)
                this.queryCarAll();
                break;
            case "2":
                //按价格降序排序
                sql = "SELECT * FROM t_CAR ORDER BY rent DESC";
                this.queryCar(sql,null);
                break;
            case "3":
                //按价格升序排序
                sql = "SELECT * FROM t_CAR ORDER BY rent ASC";
                this.queryCar(sql,null);
                break;
            case "4":
                //添加汽车
                this.addCar();
                break;
            case "5":
                //查询租赁记录
                this.queryRecord();
                break;
            case "6":
                //查看指定汽车
                sql = "SELECT * FROM t_CAR WHERE id = ?";
                this.queryCar(sql,Long.parseLong(str[1]));
                break;
            case "7":
                //按类型搜索
                sql = "SELECT * FROM t_CAR WHERE category_id = ?";
                this.queryCar(sql,Long.parseLong(str[1]));
                break;
            case "8":
                //品牌搜索
                sql = "SELECT * FROM t_CAR WHERE brand_id = ?";
                this.queryCar(sql,Long.parseLong(str[1]));
                break;
            case "9":
                //修改汽车信息
                this.updateCar(Long.parseLong(str[1]));
                break;
            default:
                this.major();
                return;
        }
        this.queryCar();
    }

    /**
     * 查询
     * @param sql
     * @param id
     */
    private void queryCar(String sql,long id) {
        Car car = new Car(id);
        this.queryCar(sql,car);
    }
    private void queryCarAll() {
        this.showCar(this.carUpdate());
    }
    private void queryRecord() {
        System.out.println("1.查询全部汽车");
        System.out.println("2.查询全部租凭记录");
        System.out.println("3+ 用户编号 查看指定用户租凭记录");
        System.out.println("4+ 汽车编号 查看指定汽车租凭记录");
        System.out.println("Rest.主界面");

        String[] str = InputUtil.next().split("\\+");
        String choose = str[0];
        switch (choose) {
            case "1":
                //查询全部汽车
                this.queryCarAll();
                break;
            case "2":
                //查询全部租凭记录
                this.showRecord(this.recordUpdate());
                break;
            case "3":
                //查看指定用户租凭记录
                String sql = "SELECT * FROM t_record WHERE user_id = ? ORDER BY id";
                Record record = new Record(Long.parseLong(str[1]));
                this.queryRecord(sql,record);
                break;
            case "4":
                //查看指定汽车租凭记录
                sql = "SELECT * FROM t_record WHERE car_id = ? ORDER BY id";
                record = new Record(Long.parseLong(str[1]));
                this.queryRecord(sql,record);
                break;
            default:
                this.major();
                return;
        }
        this.queryRecord();
    }
    private void addCar() {
        System.out.println("============》》》汽车添加");
        System.out.println("请分别输入以下信息：");

        System.out.println("---------------------");
        System.out.println("品牌如下：");
        System.out.println("品牌编号\t品牌名");
        Set<Map.Entry<Long,Brand>> brandSet = brandMap.entrySet();
        for (Map.Entry<Long,Brand> str:brandSet) {
            System.out.printf("   %d\t%s\n",str.getKey(),str.getValue().getName());
        }
        long brandId;
        while (true) {
            System.out.print("请选择品牌编号：");
            brandId = InputUtil.nextLong();
            if (brandMap.get(brandId) == null) {
                System.out.println("品牌编号不存在,请重新输入");
            }else {
                break;
            }
        }

        System.out.println("---------------------");
        System.out.println("类别如下：");
        System.out.println("类别编号\t类别名");
        Set<Map.Entry<Long,CarCategory>> carCategorySet = carCategoryMap.entrySet();
        for (Map.Entry<Long,CarCategory> str:carCategorySet) {
            System.out.printf("   %d\t%s\n",str.getKey(),str.getValue().getName());
        }
        long carCategoryId;
        while (true) {
            System.out.print("请选择类别编号：");
            carCategoryId = InputUtil.nextLong();
            if (carCategoryMap.get(carCategoryId) == null) {
                System.out.println("类别编号不存在,请重新输入");
            }else {
                break;
            }
        }

        System.out.println("---------------------");
        System.out.print("\n型号：");
        String model = InputUtil.next();
        System.out.println("---------------------");
        System.out.print("\n车牌号：");
        String carNumber = InputUtil.next();
        System.out.println("---------------------");
        System.out.print("\n概要：");
        String comments = InputUtil.next();
        System.out.println("---------------------");
        System.out.print("\n颜色：");
        String color = InputUtil.next();
        System.out.println("---------------------");
        System.out.print("\n汽车价格：");
        double price = InputUtil.nextDouble();
        System.out.println("---------------------");
        System.out.print("\n每日租金：");
        double rent = InputUtil.nextDouble();
        System.out.println("---------------------");
        System.out.print("\n是否可借(0:可借,1:不可借)：");
        int status = InputUtil.nextInt();
        System.out.println("---------------------");
        System.out.print("\n是否上架(0:上架,1:下架)：");
        int useable = InputUtil.nextInt();

        String sql = "INSERT INTO t_car(rent,status,useable,id,car_number,brand_id,model,color,category_id,t_comments,price)" +
                        " VALUES(?,?,?,t_car_id_seq.nextval,?,?,?,?,?,?,?)";

        Car car = new Car(-1,carNumber,brandId,model,color,carCategoryId,comments,price,rent,status,useable);
        int result = Integer.parseInt(this.sqlLink(SqlUtil.updateSql(sql,InfoValue.CAR),car));
        if (result == 1) {
            System.out.println("添加成功!");
        }else {
            System.out.println("添加失败!");
        }
    }
    private void updateCar() {
        System.out.println("请输入需要修改的汽车编号：");
        long id = InputUtil.nextLong();
        this.updateCar(id);
    }
    private void updateCar(Long id) {
        String sql = "SELECT * FROM t_CAR WHERE id = ?";
        Car car = new Car(id);
        List<Car> carList = this.queryCar(sql,car);
        if (carList.size() > 0) {
            this.updateCar(carList.get(0));
        }else {
            System.out.println("车辆不存在");
        }
    }
    private int updateCar (String sql,Car car) {
        return Integer.parseInt(this.sqlLink(SqlUtil.updateSql(sql,InfoValue.CAR),car));
    }
    private void updateCar(Car car) {
        if (car != null) {
            if (car.getStatus() == 1) {
                System.out.println("已租赁汽车,暂不可修改");
                return;
            }
            System.out.println("1.租赁价格  2.上架下架(上架改下架,下架改上架)");
            switch (InputUtil.next()) {
                case "1":
                    System.out.println("现在的租赁价格是："+car.getRent());
                    System.out.println("请输入新的租赁价格：");
                    double rent = InputUtil.nextDouble();
                    String sql = "UPDATE t_car SET rent = ? WHERE id = ?";
                    car = new Car(car.getId(),rent);
                    System.out.println(updateCar(sql,car) == 1?"修改成功":"修改失败");
                    break;
                case "2":
                    sql = "UPDATE t_car SET useable = ? WHERE id = ?";
                    car = new Car(car.getId(),car.getUseable()==1?0:1);
                    System.out.println(updateCar(sql,car) == 1?"修改成功":"修改失败");
                    break;
                default:
                    break;
            }
        }else {
            System.out.println("车辆不存在");
        }
    }
    @Override
    public List<Car> queryCar(String sql,Car car) {
        List<Car> carList = JSON.parseArray(this.sqlLink(SqlUtil.querySql(sql,InfoValue.CAR),car),Car.class);
        this.showCar(carList);
        return carList;
    }
    @Override
    public List<Record> queryRecord(String sql,Record record) {
        sql = SqlUtil.querySql(sql,InfoValue.RECORD);
        List<Record> recordList = JSON.parseArray(this.sqlLink(sql,record),Record.class);
        this.showRecord(recordList);
        return recordList;
    }
    @Override
    public void showRecord(List<Record> recordList) {
        this.userUpdate();
        this.carUpdate();
        System.out.println("============================================================================================================================================");
        System.out.println("编号\t汽车编号\t汽车名称\t 用户编号   用户名    \t每日租金   租金总额    备注\t\t品牌   \t 类型   \t\t借车时间 \t\t\t\t还车时间");
        if (recordList != null) {
            for (Record obj: recordList) {
                Car car = carMap.get(obj.getCarId());
                User user = userMap.get(obj.getUserId());
                System.out.printf("%-4s"," "+obj.getId());
                System.out.printf("%-8s","  "+car.getId());
                System.out.printf("%-10s"," "+car.getModel());
                System.out.printf("%-8s","\t"+user.getId());
                System.out.printf("%-10s",user.getUsername());
                System.out.printf("%-10s","\t"+car.getRent());
                System.out.printf("%-10s","  "+(obj.getReturnDate() == null?"未归还":obj.getPayment()));
                System.out.printf("%-10s",car.getComments());
                System.out.printf("%-8s","\t"+brandMap.get(car.getBrandId()).getName());
                System.out.printf("%-8s",carCategoryMap.get(car.getCategoryId()).getName());
                System.out.printf("%-25s","\t"+obj.getStartDate());
                System.out.printf("%-15s",obj.getReturnDate() == null?"未归还":obj.getReturnDate());
                System.out.println();
            }
        }
    }
    @Override
    public void showCar (List<Car> carList) {
        System.out.println("==========================================================================================================");
        System.out.println("编号  \t汽车名称  \t\t  备注 \t\t\t 品牌  \t\t\t  类型\t\t\t价格 \t\t是否可租\t是否上架");
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
                System.out.printf("%-8s",(obj.getUseable()==0)?"上架":"下架");
                System.out.println();
            }
        }

    }
}
