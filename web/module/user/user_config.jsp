<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/5/19
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户设置</title>
  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link rel="stylesheet" href="../../module/style/common/common.css">
  <link rel="stylesheet" href="user_config.css">
</head>
<body>
<jsp:include page="/module/style/common/header.jsp"></jsp:include>
    <div class="profile-wrap" style="margin-top: 10px">
  <h2 class="profile-title"><span class="glyphicon glyphicon-cog"></span>设置</h2>
  <div class="profile-main">
    <div class="profile-tab clearfix">
      <a href="#user_secrt">账号隐私</a>
      <a href="#user_view">信息修改</a>


      <a href="#password_view">密码修改</a>
      <a href="#account_bind">帐号绑定</a>
    </div>


    <div id="tab_content">
      <div id="user_secrt" class="content content-a">
        <div class="show-wrap">
          <div class="combine_secrt user_setting">
            <div class="show-main clearfix">
              <p class="show-title">姓名显示</p>
              <p class="show-value">jerry</p>
              <p class="tool-main">
                <a href="#" class="edit-btn" onclick="show_detail('user_setting')">设置</a>
              </p>
            </div>
            <div class="edit_main tpl-main">
              <h3 class="title">姓名显示</h3>
              <div class="edit-content clearfix">
                <div class="edit-right">
                  <form>
                    <ul class="form-list">
                      <li><label><input type="radio" value="0" name="show_name">显示姓名</label></li>
                      <li><label><input type="radio" value="1" name="show_name">显示花名</label></li>
                      <li>
                        <div class="btn-wrap">
                          <button type="submit" class="btn btn-primary">确定</button>
                          <button class="btn btn-light" onclick="cancel('user_setting');">取消</button>
                        </div>
                      </li>
                    </ul>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!--个人信息修改begin-->
      <div id="user_view" class="content content-a">
        <div class="SR_inputTable">
          <div class="SR_inputTableContent">
            <div>
              <table>

                <tr>
                  <td class="SR_inputTitle">
                    姓名

                  </td>
                  <td>
                    <input name="customer_name"
                           class="SR_pureInput">
                  </td>


                </tr>


                <tr>
                  <td class="SR_inputTitle">
                    学校:

                  </td>
                  <td colspan="3">
                    <input name="school" readonly="readonly" id="school" class="SR_pureInput" placeholder="请选择学校">
                  </td>
                </tr>
                <tr>
                  <td class="SR_inputTitle">
                    楼号:

                  </td>
                  <td colspan="3">
                    <input name="hostel_num" readonly="readonly" id="hostel_num" class="SR_pureInput" placeholder="请选择校区">
                  </td>
                </tr>
                <tr>
                  <td class="SR_inputTitle">
                    宿舍号:
                  </td>
                  <td>
                    <input  name="hostel" id="hostel" readonly="readonly" placeholder="请选择宿舍"
                           class="SR_pureInput">
                    <span style="display: none" id="hostel_span"></span>
                  </td>
                </tr>
                <tr style="height: 10px">

                </tr>
                <tr>
                  <td></td>
                  <td>
                    <button class="btn btn-info" onclick="updateHostel()" >确定</button>
                  </td>
                </tr>

              </table>

            </div>
          </div>
        </div>

      </div>
      <!--个人信息修改end-->
      <div id="password_view" class="content content-b">
        <div class="SR_inputTable">
          <div class="SR_inputTableContent">
            <div>
              <table>

                <tr>
                  <td class="SR_inputTitle">
                    旧密码:

                  </td>
                  <td>
                    <input name="password"
                           class="SR_pureInput">
                  </td>



                </tr>
                <tr>
                  <td class="SR_inputTitle">
                    新密码:

                  </td>
                  <td colspan="3">
                    <input name="new_password"  class="SR_pureInput"
                            >
                  </td>
                </tr>
                <tr>
                  <td class="SR_inputTitle">
                    再次输入新密码:

                  </td>
                  <td colspan="3">
                    <input name="new_re_password"  class="SR_pureInput">
                  </td>
                </tr>


              </table>
            </div>
          </div>
        </div>
      </div>
      <div id="account_bind" class="content content-c">
        Content C
      </div>
    </div>


  </div>



</div>
</body>
</html>
<!--<script src="../../module/style/jquery/jquery.min.js"></script>-->
<script src="../../module/style/rdcp/rdcp.js"></script>
<script src="../../module/style/cityselector/js/lazyload-min.js"></script>
<script>
  rdcp.ready(function(){

    $(".profile-wrap .profile-main .profile-tab a").bind("click",function(){
      $(this).parent(".profile-tab").children("a").removeClass("active");
      $(this).addClass("active");
    })
    $(".profile-wrap .profile-main .profile-tab a").eq(0).click();
//        $("#tab_content .content").hide();
//        $("#tab_content .content").eq(0).show();

    LazyLoad.css(["../../module/style/cityselector/css/cityStyle.css"], function () {
      LazyLoad.js(["../../module/style/cityselector/js/cityScript.js","../../module/style/cityselector/js/hostelScript.js","../../module/style/cityselector/js/hostelNumScript.js"], function () {
        var test = new schoolSelector.Init("school");
        var hosteltest = new hostelSelector.Init("hostel_num");
        var hostelNumberSelector = new hostelNumSelector.Init("hostel");
      });
    });
  })
  //显示设置面板
  function show_detail(classid){
    $("."+classid+" .show-main").hide();
    $("."+classid+" .tpl-main").show();

  }
  function cancel(classid){
    $("."+classid+" .tpl-main").hide();
    $("."+classid+" .show-main").show();
  }
  //更新学生信息
  function updateHostel(){
    if($("input[name='customer_name']").val()==""){
      rdcp.toastrWarnMessage("请填写姓名","系统提示");
      return;
    }
    if($("#hostel").val()!=""){
      $.ajax({
        url:"../../hostel/updateHostelUser.do",
        data:{"id":$("#hostel_span").text(),"user_id":$("#user_id").val(),"name":$("input[name='customer_name']").val()},
        success:function(data){
          var obj=rdcp.str2json(data);
          if(obj.status=="success"){
            rdcp.toastrSuccessMessage("更新用户信息成功");
          }
        }
      })
    }
  }
</script>