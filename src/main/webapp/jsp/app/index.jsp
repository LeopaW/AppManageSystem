<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Leopa
  Date: 2019/4/15
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
    <style>

    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <jsp:include page="/jsp/common/header.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form action="${ctx}/app/query" method="post" class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-input-inline">
                        <input type="hidden" name="pageNum" lay-verify="title" value="1">
                    </div>
                    <label class="layui-form-label">软件名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="softwareName" lay-verify="title" autocomplete="off" placeholder="请输入名称" class="layui-input">
                    </div>
                    <label class="layui-form-label">APP状态</label>
                    <div class="layui-input-inline">
                        <select name="appStatus" lay-filter="aihao">
                            <option value="0">-请选择-</option>
                            <c:forEach items="${appStatuses}" var="obj">
                                <option value="${obj.id}">${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <label class="layui-form-label">所属平台</label>
                    <div class="layui-input-inline">
                        <select lay-filter="aihao" name="appFlatform">
                            <option value="0">-请选择-</option>
                            <c:forEach items="${appFlatfroms}" var="obj">
                                <option value="${obj.id}">${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">一级分类</label>
                    <div class="layui-input-inline">
                        <select id="levelOne" lay-filter="levelOne" name="levelOne">
                            <option value="0">-请选择-</option>
                            <c:forEach items="${levelOne}" var="obj">
                                <option value="${obj.id}">${obj.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <label class="layui-form-label">二级分类</label>
                    <div class="layui-input-inline">
                        <select name="levelTwo" lay-filter="levelTwo" id="levelTwo">
                            <option value="0">-请选择-</option>
                        </select>
                    </div>
                    <label class="layui-form-label">三级分类</label>
                    <div class="layui-input-inline">
                        <select name="levelThree" lay-filter="levelThree" id="levelThree">
                            <option value="0">-请选择-</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    </div>
                </div>


            </form>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>软件名称</th>
                        <th>APK名称</th>
                        <th>软件大小(单位M)</th>
                        <th>所属平台</th>
                        <th>所属分类(一级分类,二级分类,三级分类)</th>
                        <th>状态</th>
                        <th>下载次数</th>
                        <th>最新版本号</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${page.list}" var="obj">
                        <tr>
                            <th>${obj.softwareName}</th>
                            <th>${obj.apkName}</th>
                            <th>${obj.softwareSize}</th>
                            <th>${obj.flatformId}</th>
                            <th>
                                <c:if test="${obj.flatformId eq 1}">
                                    手机
                                </c:if>
                                <c:if test="${obj.flatformId eq 2}">
                                    平板
                                </c:if>
                                <c:if test="${obj.flatformId eq 3}">
                                    通用
                                </c:if>
                            </th>
                            <th>
                                ${obj.categoryLevel1.categoryName}->${obj.categoryLevel2.categoryName}->${obj.categoryLevel3.categoryName}
                            </th>
                            <th>${obj.downloads}</th>
                            <th>${obj.newAppVersion.versionNo}</th>
                            <th><button>点击操作</button></th>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>
                            共${page.total}条记录 第${page.pageNum} / ${page.pages}页
                        </td>
                        <td colspan="8">
                            <a href="">首页</a>
                            <a href="">上一页</a>
                            <a href="">下一页</a>
                            <a href="">尾页</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <jsp:include page="/jsp/common/footer.jsp"/>

</div>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element','form','jquery'], function(){
        var element = layui.element;
        var form = layui.form;
        var $ = layui.jquery;

        //一级分类start================================
        form.on('select(levelOne)',function (data) {

            //获取id
            var levelOneId = $('#levelOne').val();
            // alert($('#levelOne').val());
            if(levelOneId == 0 ){
                //清空levelTwo
                var html = '<option value="0">-请选择-</option>';
                $('#levelTwo').html(html);
                form.render();
                return ;
            }else{
                $.ajax({
                    url:'${ctx}/category/queryLevelTwoByLevelOne/'+levelOneId,
                    type:'get',
                    success:function (data) {
                        //根据data修改数据,重新渲染就OK了.
                        var html = '<option value="0">-请选择-</option>';
                        var len = data.length;
                        for(var i = 0 ; i < len ; i++){
                            html += '<option value="'+data[i].id+'">'+data[i].categoryName+'</option>';
                        }
                        //选择levelTwo更新
                        $('#levelTwo').html(html);
                        form.render();
                    }
                })
            }
           // alert(12313);

            // //选择二级的选择框
            // var html = '<option>手机</option>';
            // $('#levelTwo').html(html);
            // //重新渲染
            // form.render();
        });
        //一级分类end====================================


        //二级分类start================================
        form.on('select(levelTwo)',function (data) {

            //获取id
            var levelTwoId = $('#levelTwo').val();
            if(levelTwoId == 0 ){
                //清空levelTwo
                var html = '<option value="0">-请选择-</option>';
                $('#levelThree').html(html);
                form.render();
                return ;
            }else{
                $.ajax({
                    url:'${ctx}/category/queryLevelThreeByLevelTwo/'+levelTwoId,
                    type:'get',
                    success:function (data) {
                        //根据data修改数据,重新渲染就OK了.
                        var html = '<option value="0">-请选择-</option>';
                        var len = data.length;
                        for(var i = 0 ; i < len ; i++){
                            html += '<option value="'+data[i].id+'">'+data[i].categoryName+'</option>';
                        }
                        //选择levelTwo更新
                        $('#levelThree').html(html);
                        form.render();
                    }
                })
            }
            // alert(12313);

            // //选择二级的选择框
            // var html = '<option>手机</option>';
            // $('#levelTwo').html(html);
            // //重新渲染
            // form.render();
        });
        //二级分类end====================================



    });
</script>
</body>
<%--js--%>


</html>
