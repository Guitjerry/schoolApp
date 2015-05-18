<%--
  Created by IntelliJ IDEA.
  User: jiangbin
  Date: 15/5/17
  Time: 下午3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>页面头部</title>
</head>
<body>
<input type="hidden" value="${sessionScope.user.id}" id="user_id"/>
<input type="hidden" value="${sessionScope.user.name}" id="user_name"/>
<input type="hidden" value="${sessionScope.user.account}" id="user_account"/>
<input type="hidden" value="${sessionScope.user.sticker}" id="user_sticker"/>


<%--<c:if test="${sessionScope.user.account} !=null">--%>
<%--<input type="text" value="${sessionScope.user.sticker}" id="user_sticker"/>--%>
<%--</c:if>--%>
<%--<c:if test="${sessionScope.user.account} ==null">--%>
    <%--<input type="text" value="aaa" id="user_sticker"/>--%>
<%--</c:if>--%>

<div class="header navbar  navbar-default navbar-fixed-top">
  <div class="header-inner">
    <ul class="nav navbar-nav  pull-right">
      <li class="dropdown" id="header-notification-bar"
          style="outline: 0px; box-shadow: rgba(102, 188, 230, 0) 0px 0px 13px; outline-offset: 20px;">
        <a data-toggle="dropdown" class="dropdown-toggle" data-hover="dropdown-toggle">
          <button class="btn btn-primary">
            <span class="glyphicon glyphicon-bell">消息</span>
            <span class="badge">9</span>
          </button>
        </a>
        <ul class="dropdown-menu extended notification">
          <li>
            <p>
              14条消息
            </p>
          </li>
          <li>
            <div class="slimScrollDiv"
                 style="position: relative; overflow: hidden; width: auto; height: 250px;">
              <ul class="dropdown-menu-list scroller"
                  style="height: 250px; overflow: hidden; width: auto;">
                <li>
                  <a href="#">
                                    <span class="label label-sm label-icon label-success">
                                        <i class="glyphicon glyphicon-edit"></i>
                                    </span>
                    新用户注册
                                    <span class="time">
                                        1mius
                                    </span>
                  </a>
                </li>
                <li>
                  <a href="#">
                                    <span class="label label-sm label-icon label-danger">
                                        <i class="glyphicon glyphicon-edit"></i>
                                    </span>
                    Server #12 overloaded.
                                    <span class="time">
                                        15 mins
                                    </span>
                  </a>
                </li>
                <li>
                  <a href="#">
                                    <span class="label label-sm label-icon label-warning">
                                        <i class="glyphicon glyphicon-edit"></i>
                                    </span>
                    Server #2 not responding.
                                    <span class="time">
                                        22 mins
                                    </span>
                  </a>
                </li>
                <li>
                  <a href="#">
                                    <span class="label label-sm label-icon label-danger">
                                        <i class="glyphicon glyphicon-edit"></i>
                                    </span>
                    Database overloaded 68%.
                                    <span class="time">
                                        2 hrs
                                    </span>
                  </a>
                </li>
              </ul>
              <div class="slimScrollBar"
                   style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 160.25641025641px; background: rgb(161, 178, 189);"></div>
              <div class="slimScrollRail"
                   style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
            </div>
          </li>
          <li class="external">
            <a href="#">See all notifications <i class="m-icon-swapright"></i></a>
          </li>
        </ul>

      </li>


      <li class="dropdown" id="header-chanllage-bar"
          style="outline: 0px; box-shadow: rgba(221, 81, 49, 0) 0px 0px 13px; outline-offset: 20px;">
        <a data-toggle="dropdown" class="dropdown-toggle" data-hover="dropdown-toggle">
          <button class="btn btn-danger">
            <span class="glyphicon glyphicon-globe">挑战</span>
            <span class="badge">5</span>
          </button>
        </a>
        <ul class="dropdown-menu extended inbox">
          <li>
            <p>
              You have 12 new messages
            </p>
          </li>
          <li>
            <div class="slimScrollDiv"
                 style="position: relative; overflow: hidden; width: auto; height: 250px;">
              <ul class="dropdown-menu-list scroller"
                  style="height: 250px; overflow: hidden; width: auto;">
                <li>
                  <a href="inbox.html?a=view">
                                    <span class="photo">
                                        <img src="../../module/main/img/profile_user.jpg" alt="">
                                    </span>
                                    <span class="subject">
                                        <span class="from">
                                            Lisa Wong
                                        </span>
                                        <span class="time">
                                            Just Now
                                        </span>
                                    </span>
                                    <span class="message">
                                         Vivamus sed auctor nibh congue nibh. auctor nibh auctor nibh...
                                    </span>
                  </a>
                </li>
                <li>
                  <a href="inbox.html?a=view">
                                    <span class="photo">
                                        <img src="../../module/main/img/profile_user.jpg" alt="">
                                    </span>
                                    <span class="subject">
                                        <span class="from">
                                            Richard Doe
                                        </span>
                                        <span class="time">
                                            16 mins
                                        </span>
                                    </span>
                                    <span class="message">
                                         Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh...
                                    </span>
                  </a>
                </li>
                <li>
                  <a href="inbox.html?a=view">
                                    <span class="photo">
                                        <img src="../../module/main/img/profile_user.jpg" alt="">
                                    </span>
                                    <span class="subject">
                                        <span class="from">
                                            Bob Nilson
                                        </span>
                                        <span class="time">
                                            2 hrs
                                        </span>
                                    </span>
                                    <span class="message">
                                         Vivamus sed nibh auctor nibh congue nibh. auctor nibh auctor nibh...
                                    </span>
                  </a>
                </li>
                <li>
                  <a href="inbox.html?a=view">
                                    <span class="photo">
                                        <img src="../../module/main/img/profile_user.jpg" alt="">
                                    </span>
                                    <span class="subject">
                                        <span class="from">
                                            Lisa Wong
                                        </span>
                                        <span class="time">
                                            40 mins
                                        </span>
                                    </span>
                                    <span class="message">
                                         Vivamus sed auctor 40% nibh congue nibh...
                                    </span>
                  </a>
                </li>
                <li>
                  <a href="inbox.html?a=view">
                                    <span class="photo">
                                        <img src="../../module/main/img/profile_user.jpg" alt="">
                                    </span>
                                    <span class="subject">
                                        <span class="from">
                                            Richard Doe
                                        </span>
                                        <span class="time">
                                            46 mins
                                        </span>
                                    </span>
                                    <span class="message">
                                         Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh...
                                    </span>
                  </a>
                </li>
              </ul>
              <div class="slimScrollBar"
                   style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 140.134529147982px; background: rgb(161, 178, 189);"></div>
              <div class="slimScrollRail"
                   style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
            </div>
          </li>
          <li class="external">
            <a href="inbox.html">See all messages <i class="m-icon-swapright"></i></a>
          </li>
        </ul>

      </li>

      <li class="dropdown dropdown-user">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-close-others="true">
          <img alt class="img-circle" src="../../module/main/img/profile_user.jpg" style="width:36px">
                        <span class="username username-hide-on-mobile">
                            Nick
                        </span>
          <i class="glyphicon glyphicon-chevron-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-menu-default">
          <li>
            <a href="../../../module/user/user_config.html">
              <i class="glyphicon glyphicon-user"></i>
              个人设置
            </a>
            <a href="#">
              <i class="glyphicon glyphicon-wrench"></i>
              密码设置
            </a>
            <a href="#">
              <i class="glyphicon glyphicon-off"></i>
              退出登陆
            </a>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</div>
</body>
</html>
