rdcp.ready(function(){
    login_click($(".user-login-reg .ui-tab-control ul li").eq(0))
    initValidate();
});

//会员注册Tab
function regiest_click(obj){
    var obj=$(obj);
    obj.parent("ul").children("li").eq(0).removeClass("active").addClass("active");
    obj.parent("ul").children("li").eq(1).removeClass("active");
    $(".ui-tab-container .ui-tab-toggle").eq(0).removeClass("hide").addClass("hide");
    $(".ui-tab-container .ui-tab-toggle").eq(1).removeClass("hide");
}
function login_click(obj){
    var obj=$(obj);
    obj.parent("ul").children("li").eq(1).removeClass("active").addClass("active");
    obj.parent("ul").children("li").eq(0).removeClass("active");
    $(".ui-tab-container .ui-tab-toggle").eq(1).removeClass("hide").addClass("hide");
    $(".ui-tab-container .ui-tab-toggle").eq(0).removeClass("hide");
}
//注册会员
function regiest_user(){
    if($("input[name='password']").val()!=$("input[name='re_password']").val()){
        $("#msg").val("");
    }else{
        $("#msg").val("default");
    }
    if(validateForm("regiest_form")){
        var param=rdcp.serializeObject('#regiest_form');
        $.ajax({
            url:"user/insertSimple.do",
            data:param,
            type:"post",
            success:function(data){
                if(data.status='success'){
                    alert('注册用户成功')
                }
            }
        })

    }
}