var hostelNumSelector = {};
hostelNumSelector.hotCityhtmls = "";

hostelNumSelector.Init = function (input) {

    $("#" + input).click(function () {
        var locationParam=$("#hostel_num").val();
        if(locationParam==""){
            rdcp.toastrErrorMessage("设置宿舍前必须选择校区楼盘","系统提示");
            return;
        }
        //请求得到学校Id
        $.ajax({
            url:"../../school/selectSchoolByName.do",
            data:{"name":$("#school").val()},
            success:function(data){
                var school_obj=rdcp.str2json(data);

                if(school_obj.status=="success"){
                    //根据学校,楼盘找到相关宿舍
                    $.ajax({
                        url:"../../hostel/selectHostelByBuildAndSchool.do",
                        data:{"name":$("#hostel_num").val(),"school_id":school_obj.entity.id},
                        success:function(data){
                            var hostel_obj=rdcp.str2json(data);

                            if(hostel_obj.status=="success"){
                                hostelNumSelector.hotCityhtmls="";
                                for (var i = 0; i <hostel_obj.entity.length; i++) {
                                    hostelNumSelector.hotCityhtmls += "<li class='js_cityName' hostel='"+hostel_obj.entity[i].hostels[0].id+"'"+">" +hostel_obj.entity[i].hostels[0].name + "</li>";
                                }

                                hostelNumSelector.template = '<div class="city-box" id="js_cityBox"><div class="prov-city" id="js_provCity"><p>校区宿舍<span style="padding-left: 300px;cursor: pointer" onclick="hideDiv()">x</span></p><ul>' + hostelNumSelector.hotCityhtmls + '</ul></div></div>';
                                $("#js_cityBox").remove();

                                $("body").append(hostelNumSelector.template);

                                var _top = $("#" + input).offset().top + 40,
                                    _left = $("#" + input).offset().left,
                                    _width = $(window).width();
                                if (_width - _left < 450) {
                                    $("#js_cityBox").css({ "top": _top + "px", "right": "0px" }).addClass("rightSelector");
                                }
                                else {
                                    $("#js_cityBox").css({ "top": _top + "px", "left": _left + "px" });
                                }


                                $("#js_cityBox").on("click", ".js_cityName", function (e) {
                                    e.stopPropagation();
                                    $("#" + input).val($(this).html());

                                    $("#" + input).next("span").text($(this).attr("hostel"))
                                    $("#js_cityBox").remove();
                                });

                            }
                        }
                    })
                }
            }
        })

    });
}
function hideDiv(){
    $(".city-box").hide();
}