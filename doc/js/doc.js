/**
 * 弹窗
 */
function pop(t){
	var pop=document.getElementById("pop");
	var img=document.getElementById("popImg");
	var body=document.getElementsByTagName("body")[0];
	
	var h=body.offsetHeight;
	if(h<window.innerHeight){
		h=window.innerHeight;
	}
	var w=body.offsetWidth;
	//设置pop的size
	pop.style.width=body.offsetWidth+"px";
	pop.style.height=h+"px";
	
	//设置图片位置
	var iw=t.naturalWidth;
	var ih=t.naturalHeight;
	img.style.marginLeft=(w-iw)/2+"px";
	img.style.marginTop=img.offsetTop+(window.innerHeight-ih)/2+"px";
	
	//点击触发效果
	img.setAttribute("src",t.getAttribute("src"));
	pop.style.display="block";
	img.style.display="block";
}
/**
 * 隐藏弹窗
 * @param {Object} t
 */
function hidePop(t){
	var img=document.getElementById("popImg");
	
	t.style.display="none";
	img.style.display="none";
}


/**
 * 时间
 */
function today(){
	var now=new Date();
	document.getElementById("year").innerHTML=now.getFullYear();
	document.getElementById("month").innerHTML=now.getMonth()+1;
	document.getElementById("date").innerHTML=now.getDate();
	var xq="一";
	if(now.getDay()==1){
		xq="一";
	}else if(now.getDay()==2){
		xq="二";
	}else if(now.getDay()==3){
		xq="三";
	}else if(now.getDay()==4){
		xq="四";
	}else if(now.getDay()==5){
		xq="五";
	}else if(now.getDay()==6){
		xq="六";
	}else if(now.getDay()==7){
		xq="天";
	}
	document.getElementById("xq").innerHTML=xq;
}
