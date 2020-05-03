<%--
  Created by IntelliJ IDEA.
  User: BLAKD
  Date: 2020/4/9
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>全部作品</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Autocomplate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Dropdown.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/icon-Popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/demo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/allworks.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/myCss.css">

    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/md5.js"></script>

</head>

<body>
<div class="outer-wrap">
    <div class="navigater">
        <div class="login-box fr">
            <div id="alreadyLogin" class="sign-in hidden">
                <span class="login">你好，</span>
                <a class="login" style="color: #1a1a1a" id="user-name" href="/self" target="_blank"></a>
                <em class="login">|</em>
                <a id="exit-btn" class="login" href="javascript:" onclick="exitLogin()">退出</a>
            </div>
            <div id="needLogin" style="float: right;">
                <a id="loginBtn" class="login" href="javascript:" onclick="loginBtnClick()">登录</a>
                <em class="login">|</em>
                <a id="reg-btn" class="login" style="margin-right: 10px;" href="/register" target="_blank">&nbsp;注册</a>
            </div>
        </div>
    </div>
    <dialog class="loginDialog" id="loginDialog">
        <div class="loginDiv">
            <ul>
                <h2 class="loginTitle">用户登录</h2>
                <li><label>账号</label><input type="text" id="userId"/></li>
                <li><label>密码</label><input type="password" id="password"/></li>
                <li>
                    <a id="confirmLoginBtn" class="loginBtn" href="javascript:" onclick="cofirmLogin()">登录</a>
                    <a id="loginDialogCloseBtn" class="loginBtn" href="javascript:"
                       onclick="closeLoginDialog()">取消登录</a>
                </li>
            </ul>

        </div>
    </dialog>

    <div class="header-box">
        <div class="logo">
            <a href="/index"></a>
        </div>
        <div class="search-box">
            <input type="text" name="" id="" class="search" placeholder="请输入要查找的内容" autocomplete="off">
            <a href="javascript:;" class="search-btn">
            </a>
        </div>
        <div class="my-book">
            <a href="javascript:;" class="bookshelf">我的书架</a>
        </div>
    </div>

    <div class="main-nav-menu">
        <ul>
            <li class="nav-kind">
                <em>
                    <i></i>
                    <i></i>
                    <i></i>
                </em> 作品分类 <i class="arrow-img"></i>

            </li>
            <div class="center-left">
                <ul>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe642</em>
                        玄幻
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe62f</em>
                        奇幻
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe60f</em>
                        武侠
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe610</em>
                        仙侠
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe62c</em>
                        都市
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe602</em>
                        军事
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe616</em>
                        历史
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe612</em>
                        游戏
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe631</em>
                        体育
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe603</em>
                        科幻
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe641</em>
                        灵异
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe607</em>
                        言情
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe614</em>
                        耽美
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&#xe617</em>
                        二次元
                    </li>
                    <li class="novel-kind">
                        <em class="iconfont">&nbsp;</em>
                    </li>
                </ul>
            </div>
            <li class="nav-li" onclick="location.href='/allWorks'">全部作品</li>
            <li class="nav-li" onclick="location.href='/rankPage'">排行</li>
        </ul>
    </div>

    <div class="main-content-box">
        <div class="box-left">
            <div class="tags-box">
                <p>已选</p>
                <ul class="s-tags" id="selected">

                </ul>
            </div>
            <div class="tags-box">
                <p>分类</p>
                <ul class="s-tags">
                    <li><a data-category="0" href="javascript:void(0);" class="tags" type="categories">全部</a></li>
                    <li><a data-category="1" href="javascript:void(0);" class="tags" type="categories">玄幻</a></li>
                    <li><a data-category="6" href="javascript:void(0);" class="tags" type="categories">武侠</a></li>
                    <li><a data-category="11" href="javascript:void(0);" class="tags" type="categories">仙侠</a></li>
                    <li><a data-category="17" href="javascript:void(0);" class="tags" type="categories">奇幻</a></li>
                    <li><a data-category="24" href="javascript:void(0);" class="tags" type="categories">科幻</a></li>
                    <li><a data-category="32" href="javascript:void(0);" class="tags" type="categories">都市</a></li>
                    <li><a data-category="39" href="javascript:void(0);" class="tags" type="categories">言情</a></li>
                    <li><a data-category="46" href="javascript:void(0);" class="tags" type="categories">历史</a></li>
                    <li><a data-category="51" href="javascript:void(0);" class="tags" type="categories">军事</a></li>
                    <li><a data-category="59" href="javascript:void(0);" class="tags" type="categories">游戏</a></li>
                    <li><a data-category="64" href="javascript:void(0);" class="tags" type="categories">体育</a></li>
                    <li><a data-category="70" href="javascript:void(0);" class="tags" type="categories">灵异</a></li>
                    <li><a data-category="76" href="javascript:void(0);" class="tags" type="categories">耽美</a></li>
                    <li><a data-category="79" href="javascript:void(0);" class="tags" type="categories">二次元</a></li>
                </ul>
            </div>
            <div class="tags-box">
                <p>状态</p>
                <ul class="s-tags">
                    <li><a data-states="0" href="javascript:void(0);" class="tags" type="status">全部</a></li>
                    <li><a data-states="1" href="javascript:void(0);" class="tags" type="status">连载</a></li>
                    <li><a data-states="2" href="javascript:void(0);" class="tags" type="status">完本</a></li>
                </ul>
            </div>
            <div class="tags-box">
                <p>属性</p>
                <ul class="s-tags">
                    <li><a data-ifvip="-1" href="javascript:void(0);" class="tags" type="ifVip">全部</a></li>
                    <li><a data-ifvip="0" href="javascript:void(0);" class="tags" type="ifVip">免费</a></li>
                    <li><a data-ifvip="1" href="javascript:void(0);" class="tags" type="ifVip">VIP</a></li>
                </ul>
            </div>
            <div class="tags-box">
                <p>字数</p>
                <ul class="s-tags">
                    <li><a data-count="0" href="javascript:void(0);" class="tags" type="num">全部</a></li>
                    <li><a data-count="1" href="javascript:void(0);" class="tags" type="num">30万字以下</a></li>
                    <li><a data-count="2" href="javascript:void(0);" class="tags" type="num">30-50万字</a></li>
                    <li><a data-count="3" href="javascript:void(0);" class="tags" type="num">50-100万字</a></li>
                    <li><a data-count="4" href="javascript:void(0);" class="tags" type="num">100-200万字</a></li>
                    <li><a data-count="5" href="javascript:void(0);" class="tags" type="num">200万字以上</a></li>
                </ul>
            </div>
        </div>
        <div class="box-right">
            <div class="r-menu">
                <span>总收藏</span>
                <span>总字数</span>
                <span>推荐票</span>
            </div>
            <ul id="bookList" class="b-list">
            </ul>
            <%--            <div class="page-box cf">--%>
            <%--                <div class="pagination fr" id="page-container" data-pagemax="5" data-page="1">--%>


            <%--                    <div class="lbf-pagination">--%>
            <%--                        <ul class="lbf-pagination-item-list">--%>

            <%--                            <li class="lbf-pagination-item"><a href="javascript:;"--%>
            <%--                                                               class="lbf-pagination-prev lbf-pagination-disabled">&lt;</a>--%>
            <%--                            </li>--%>

            <%--                            <li class="lbf-pagination-item"><a data-page="1"--%>
            <%--                                                               href="//www.qidian.com/all?orderId=&amp;style=1&amp;pageSize=20&amp;siteid=1&amp;pubflag=0&amp;hiddenField=0&amp;page=1"--%>
            <%--                                                               class="lbf-pagination-page  lbf-pagination-current">1</a>--%>
            <%--                            </li>--%>


            <%--                            <li class="lbf-pagination-item"><a data-page="2"--%>
            <%--                                                               href="//www.qidian.com/all?orderId=&amp;style=1&amp;pageSize=20&amp;siteid=1&amp;pubflag=0&amp;hiddenField=0&amp;page=2"--%>
            <%--                                                               class="lbf-pagination-page  ">2</a></li>--%>

            <%--                            <li class="lbf-pagination-item"><a data-page="3"--%>
            <%--                                                               href="//www.qidian.com/all?orderId=&amp;style=1&amp;pageSize=20&amp;siteid=1&amp;pubflag=0&amp;hiddenField=0&amp;page=3"--%>
            <%--                                                               class="lbf-pagination-page  ">3</a></li>--%>

            <%--                            <li class="lbf-pagination-item"><a data-page="4"--%>
            <%--                                                               href="//www.qidian.com/all?orderId=&amp;style=1&amp;pageSize=20&amp;siteid=1&amp;pubflag=0&amp;hiddenField=0&amp;page=4"--%>
            <%--                                                               class="lbf-pagination-page  ">4</a></li>--%>

            <%--                            <li class="lbf-pagination-item"><a data-page="5"--%>
            <%--                                                               href="//www.qidian.com/all?orderId=&amp;style=1&amp;pageSize=20&amp;siteid=1&amp;pubflag=0&amp;hiddenField=0&amp;page=5"--%>
            <%--                                                               class="lbf-pagination-page  ">5</a></li>--%>


            <%--                            <li class="lbf-pagination-item"><a--%>
            <%--                                    href="//www.qidian.com/all?orderId=&amp;style=1&amp;pageSize=20&amp;siteid=1&amp;pubflag=0&amp;hiddenField=0&amp;page=2"--%>
            <%--                                    class="lbf-pagination-next ">&gt;</a></li>--%>

            <%--                        </ul>--%>
            <%--                        <script>--%>
            <%--                            function PAGINATION_goInput() {--%>
            <%--                                function setParam(param, paramVal, url) {--%>
            <%--                                    if (!url) {--%>
            <%--                                        url = "javascript:;";--%>
            <%--                                        return url--%>
            <%--                                    }--%>
            <%--                                    var theAnchor = null;--%>
            <%--                                    var newAdditionalURL = "";--%>
            <%--                                    var tempArray = url.split("?");--%>
            <%--                                    var baseURL = tempArray[0];--%>
            <%--                                    var additionalURL = tempArray[1];--%>
            <%--                                    var temp = "";--%>
            <%--                                    if (additionalURL) {--%>
            <%--                                        var tmpAnchor = additionalURL.split("#");--%>
            <%--                                        var TheParams = tmpAnchor[0];--%>
            <%--                                        theAnchor = tmpAnchor[1];--%>
            <%--                                        if (theAnchor) additionalURL = TheParams;--%>
            <%--                                        tempArray = additionalURL.split("&");--%>
            <%--                                        for (o = 0; o < tempArray.length; o++) {--%>
            <%--                                            if (tempArray[o].split("=")[0] != param) {--%>
            <%--                                                newAdditionalURL += temp + tempArray[o];--%>
            <%--                                                temp = "&"--%>
            <%--                                            }--%>
            <%--                                        }--%>
            <%--                                    } else {--%>
            <%--                                        var tmpAnchor = baseURL.split("#");--%>
            <%--                                        var TheParams = tmpAnchor[0];--%>
            <%--                                        theAnchor = tmpAnchor[1];--%>
            <%--                                        if (TheParams) baseURL = TheParams--%>
            <%--                                    }--%>
            <%--                                    if (theAnchor) paramVal += "#" + theAnchor;--%>
            <%--                                    var rowsTxt = temp + "" + param + "=" + paramVal;--%>
            <%--                                    return "//www.qidian.com/all" + "?" + newAdditionalURL + rowsTxt--%>
            <%--                                };location.href = setParam("page", document.getElementById("PAGINATION-INPUT").value, location.href)--%>
            <%--                            }--%>
            <%--                        </script>--%>

            <%--                        <div class="lbf-pagination-jump"><input id="PAGINATION-INPUT" type="text"--%>
            <%--                                                                class="lbf-pagination-input" value="1"><a--%>
            <%--                                href="javascript:;" id="PAGINATION-BUTTON" onclick="PAGINATION_goInput()"--%>
            <%--                                class="lbf-pagination-go">GO</a></div>--%>

            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
        </div>
    </div>

    <div class="footer">
        <p>上海网警提示：网络刷单是违法 切莫轻信有返利，网上交友套路多 卖惨要钱需当心，电子红包莫轻点 个人信息勿填写，仿冒客服来行骗 官方核实最重要，招工诈骗有套路 预交费用需谨慎，低价充值莫轻信
            莫因游戏陷套路，连接WIFI要规范 确认安全再连接，抢购车票有章法 确认订单再付款，白条赊购慎使用 提升额度莫轻信，网购预付有风险 正规渠道很重要 如网民接到962110电话，请立即接听。</p>
        <div class="help">
            <a href="javascript:;">帮助中心</a>
            <a href="javascript:;">举报中心</a>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/js/allworks.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/login.js"></script>
</html>