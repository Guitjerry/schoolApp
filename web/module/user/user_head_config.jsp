<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/5/19
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>用户头像设置</title>
  <link rel="stylesheet" href="../../module/user/user_head_config.css"/>
</head>
<body>
<div style="background:#699f00; height:40px; overflow:hidden; padding:0 20px;">
  <span style=" line-height:40px; float:left;color: #fff;">上传头像</span>
  <a style="font-size:16px; font-family:'微软雅黑'; line-height:40px; color:#FFF; float:right;" href="#"  onclick="closeSlidePanel()">x</a>
</div>

<div id="NTGUID__c">
  <div class="privew">
    <div class="uploader">
      <div class="status"></div>
      <div class="file-field">

        <input type="text" name="name">
        <input class="local-file" type="file" name="file" id="resume_uploader" onchange="ajaxFileUpload()">
        <a href="#" class="button">上传照片</a>
      </div>
      <p>支持JPG、GIF、PNG格式，图片小于2M</p>
    </div>
    <div class="source_box">
      <div class="photo_cols">
        <div class="photo photo_source jcrop-default">

        </div>
      </div>
    </div>
    <div class="result_box">
      <div class="photo_cols-left">
        <div class="photo photo_large" style="height: 200px;">
        </div>
        <div class="btn-save"><a href="javascript:void(0);" class="button" onclick="update_Stick()">保存头像</a></div>

      </div>
      <div class="photo_cols-right">
        <div class="photo photo_big" style="height: 100px;"></div>
        <div class="photo photo_normal" style="height: 75px;"></div>
        <div class="photo photo_tiny" style="height: 50px;"></div>
      </div>
    </div>
  </div>
</div>
<input type="hidden" id="x1">
<input type="hidden" id="y1">
<input type="hidden" id="cw">
<input type="hidden" id="ch">
</body>
</html>
<script src="../../module/style/file/ajaxfileupload.js"></script>
<!--<script src="../../module/style/toastr/toastr.js"></script>-->
<!--<script src="../../module/style/rdcp/rdcp.toastr.js"></script>-->
<script src="../../module/style/jquery/jquery.Jcrop.min.js"></script>
<script>
  var jcrop_api, boundx, boundy;
  //当裁剪框变动时，将左上角相对图片的X坐标与Y坐标，宽度以及高度放到<input type="hidden">中(上传到服务器上裁剪会用到)
  function showCoords(c) {

    var $pcnt = $('.photo_cols-left .photo_large');
    var $pimg = $('.photo_cols-left .photo_large img');

    var $pcnt_big = $('.photo_cols-right .photo_big');
    var $pimg_big = $('.photo_cols-right .photo_big img');

    var $pcnt_nomal = $('.photo_cols-right .photo_normal');
    var $pimg_normal = $('.photo_cols-right .photo_normal img');

    var $pcnt_tiny = $('.photo_cols-right .photo_tiny');
    var $pimg_tiny = $('.photo_cols-right .photo_tiny img');
//        var $pimg_tiny = $('.photo_cols-right .photo_tiny');
    var xsize = $pcnt.width();
    var ysize = $pcnt.height();

    var xsize_big = $pcnt_big.width();
    var ysize_big = $pcnt_big.height();

    var xsize_nomal = $pcnt_nomal.width();
    var ysize_nomal = $pcnt_nomal.height();

    var xsize_tiny = $pcnt_tiny.width();
    var ysize_tiny = $pcnt_tiny.height();

    if (parseInt(c.w) > 0) {
      var rx = xsize / c.w;
      var ry = ysize / c.h;

      var rx_big = xsize_big / c.w;
      var ry_big = ysize_big / c.h;

      var rx_nomal = xsize_nomal / c.w;
      var ry_nomal = ysize_nomal / c.h;

      var rx_tiny = xsize_tiny / c.w;
      var ry_tiny = ysize_tiny / c.h;

      $pimg.css({
        width: Math.round(rx * boundx) + 'px',
        height: Math.round(ry * boundy) + 'px',
        marginLeft: '-' + Math.round(rx * c.x) + 'px',
        marginTop: '-' + Math.round(ry * c.y) + 'px'
      })
      $pimg_big.css({
        width: Math.round(rx_big * boundx) + 'px',
        height: Math.round(ry_big* boundy) + 'px',
        marginLeft: '-' + Math.round(rx_big * c.x) + 'px',
        marginTop: '-' + Math.round(ry_big * c.y) + 'px'
      })
      $pimg_normal.css({
        width: Math.round(rx_nomal * boundx) + 'px',
        height: Math.round(ry_nomal * boundy) + 'px',
        marginLeft: '-' + Math.round(rx_nomal * c.x) + 'px',
        marginTop: '-' + Math.round(ry_nomal * c.y) + 'px'
      })
      $pimg_tiny.css({
        width: Math.round(rx_tiny * boundx) + 'px',
        height: Math.round(ry_tiny * boundy) + 'px',
        marginLeft: '-' + Math.round(rx_tiny * c.x) + 'px',
        marginTop: '-' + Math.round(ry_tiny * c.y) + 'px'
      })
      $("#x1").val(c.x);
      $("#y1").val(c.y);
      $("#cw").val(c.w);
      $("#ch").val(c.h);
    }


  }
  function ajaxFileUpload() {
    $.ajaxFileUpload
    (
            {
              url:'../../user/uploadSticker.do',//用于文件上传的服务器端请求地址
              secureuri:false,//一般设置为false
              fileElementId:'resume_uploader',//文件上传空间的id属性  <input type="file" id="upload" name="upload" />
              dataType:'json',
              success: function (data)  //服务器成功响应处理函数
              {


                if(data.filename!=""&&data.filename!=undefined){
                  $(".result_box .photo_cols-left .btn-save .button").show();
                  var person_img='<img style="width:100%" id="main_img" filePath="'+data.filename+'"'+'src="'+data.upload+"/"+data.filename+'"'+'>';
                  var person_common_img='<img style="width:100%" src="'+data.upload+"/"+data.filename+'"'+'>';
                  //设置头像
                  $('.source_box .photo_cols .photo_source').empty().append(person_img);
                  $('.photo_cols-left .photo_large').empty().append(person_common_img);
                  $('.photo_cols-right .photo_big').empty().append(person_common_img);
                  $('.photo_cols-right .photo_normal').empty().append(person_common_img);
                  $('.photo_cols-right .photo_tiny').empty().append(person_common_img);

                  //启动裁剪功能
                  $("#main_img").Jcrop({
                    bgColor: 'black',
                    aspectRatio: 1 / 1,
                    onChange: showCoords,   //当裁剪框变动时执行的函数
                    onSelect: showCoords   //当选择完成时执行的函数
                  },function(){
                    var bounds=this.getBounds();
                    boundx = bounds[0];
                    boundy = bounds[1];
                  });
                }

              },
              error: function (data, status, e)//服务器响应失败处理函数
              {
                alertDiv("error  "+e);
              }
            }
    );
    return false;
  }
  /**
   * 保存裁剪后的图像
   */
  function update_Stick(){
    if($('.source_box .photo_cols .photo_source').length==0){
      rdcp.toastrErrorMessage("请上传头像图片","系统提示");
    }else{
      $.ajax({ type: "POST",
        url: "../../user/updateUserSticker.do",
        data:{"id":$("#user_id").val(),"sticker":$('.source_box .photo_cols .photo_source img').attr("filePath"),"account":$("#user_account").val()
          ,"x1":$("#x1").val(),"y1":$("#y1").val(),"cw":$("#cw").val(),"ch":$("#ch").val()},
        async: false ,
        success: function(data){
          var obj=rdcp.str2json(data);
          if(obj.status=="success"){
            rdcp.toastrSuccessMessage("更新头像成功");
            closeSlidePanel();
            location.reload();
          }

        }
      });

    }
  }
</script>
