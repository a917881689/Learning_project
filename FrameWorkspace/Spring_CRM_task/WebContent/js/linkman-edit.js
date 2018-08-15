$(function () {
	$('#btn-update').click(function () {
		$.ajax({
			url:"linkman_update",
			type:"get",
			async:true,
			data:$("update-form").serialize(),
			dataType:"json",
			success: function (result) {
				result = JSON.parse(result);
				if (result == "success") {
					alert("修改成功");
					return;
				}
				alert("修改失败");
			}
		})
	})
})


