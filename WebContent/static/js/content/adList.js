/**
 * 分页代码
 */


$(function(){
	//获得当前页的页码
	var a=$(".yeshu").text();
	//获得总页数
	var b=$(".zongyeshu").text();
	//下一页实现
	$(".next").click(function(){
		var pageIndex=a;
		pageIndex++;
		$(".next").attr("href",$('input[name=basepath]').val()+"/getAdList?pageIndex="+pageIndex);
	})
	//上一页实现
	$(".pre").click(function(){
		var pageIndex=a;
		pageIndex--;
		$(".pre").attr("href",$('input[name=basepath]').val()+"/getAdList?pageIndex="+pageIndex);
	})
	//首页实现
	$(".first").click(function(){
		$(".first").attr("href",$('input[name=basepath]').val()+"/getAdList?pageIndex=1");
	})
	//尾页实现
	$(".last").click(function(){
		var pageIndex=b;
		$(".last").attr("href",$('input[name=basepath]').val()+"/getAdList?pageIndex="+pageIndex);
	})
})
//跳转页面
function jump(){
	var pageIndex=$('#currentPageText').val();
	
	$("#jumpa").attr("href",$('input[name=basepath]').val()+"/getAdList?pageIndex="+pageIndex);
}