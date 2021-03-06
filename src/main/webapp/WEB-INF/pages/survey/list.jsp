<%--
  Created by IntelliJ IDEA.
  User: yxq
  Date: 2020/7/26
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>查询列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/lib/layui-src/css/layui.css" media="all">
    <link rel="stylesheet" href="../static/lib/font-awesome-4.7.0/css/font-awesome.css" media="all">
    <link rel="stylesheet" href="../static/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="table-search-fieldset">
            <legend>搜索查询条件</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">标题</label>
                            <div class="layui-input-inline">
                                <input type="text" name="title" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">状态</label>
                            <div class="layui-input-inline">
                                <select name="state" lay-filter="bounds">
                                    <option value="">请选择</option>
                                    <option value="创建">创建</option>
                                    <option value="执行中">执行中</option>
                                    <option value="结束">结束</option>
                                </select>
                            </div>
                        </div>

                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary" lay-submit
                                    lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"><i
                        class="fa fa-plus"></i> 添加问卷
                </button>
                <button class="layui-btn layui-btn-sm layui-btn-sm data-delete-btn" lay-event="edit"><i
                        class="fa fa-pencil"></i> 修改问卷信息
                </button>
                <button class="layui-btn layui-btn-checked layui-btn-sm data-delete-btn" lay-event="editque"><i
                        class="fa fa-pencil-square"></i> 设计问卷
                </button>
                <button class="layui-btn layui-btn-checked layui-btn-sm data-delete-btn" lay-event="preview"><i
                        class="fa fa-search"></i> 预览问卷
                </button>
                <button class="layui-btn layui-btn-checked layui-btn-sm data-delete-btn" lay-event="publish"><i
                        class="fa fa-send" aria-hidden="true"></i> 发布问卷
                </button>
                <button class="layui-btn layui-btn-checked layui-btn-sm data-delete-btn" lay-event="queryDetail"><i
                        class="fa fa-search-plus"></i> 统计信息
                </button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"><i
                        class="fa fa-remove"></i> 删除
                </button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

    </div>
</div>
<script src="../static/lib/layui-src/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: 'query',
            method: 'POST',
            contentType: 'application/json',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print'],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 100, title: 'ID', sort: true},
                {field: 'title', width: 200, title: '问卷标题', sort: true},
                {field: 'remark', width: 200, title: '备注', sort: true},
                {field: 'url', width: 600, title: '问卷链接'},
                {field: 'startTime', width: 200, title: '开始时间', sort: true},
                {field: 'endTime', width: 200, title: '结束时间', sort: true},
                {field: 'state', width: 100, title: '状态', sort: true},
                // {field: 'creator', width: 100, title: '创建人', sort: true},
                {field: 'account', title: '创建人', minWidth: 150, sort: true, templet: '<div>{{d.admin.account}}</div>'},
                {field: 'createTime', title: '创建时间', minWidth: 150, sort: true}
                // {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line'
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var result = JSON.stringify(data.field);
            /*layer.alert(result, {
                title: '最终的搜索信息'
            });*/

            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                },
                // 使用json格式传输
                contentType: 'application/json',
                where: data.field
            }, 'data');

            return false;
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加问卷',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'create',
                    end: function () {
                        table.reload('currentTableId');
                    }
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var arr = [];
                for (index in data) {
                    arr.push(data[index].id);
                }
                if (arr.length < 1) {
                    layer.msg('请选择要删除的数据', {time: 1000});
                    return;
                }
                // console.log(arr);
                $.ajax({
                    url: 'delete',
                    type: 'POST',
                    dataType: 'json',
                    data: 'ids=' + arr.join(','),
                    success: function (data) {
                        // 提示成功后关闭
                        layer.msg('删除成功', {
                            time: 500
                        }, function () {
                            parent.layer.close(index);
                            table.reload('currentTableId');
                        });
                    }
                });
            } else if (obj.event === 'edit') {  // 监听修改操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var arr = [];
                for (index in data) {
                    arr.push(data[index].id);
                }
                if (arr.length != 1) {
                    layer.msg('请选择一行数据进行修改', {time: 1000});
                    return;
                }
                var index = layer.open({
                    title: '修改问卷',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'detail?id=' + arr[0],
                    end: function () {
                        table.reload('currentTableId');
                    }
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'editque') {  // 监听修改操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var arr = [];
                for (index in data) {
                    arr.push(data[index].id);
                }
                if (arr.length != 1) {
                    layer.msg('请选择一行数据进行编辑', {time: 1000});
                    return;
                }
                var index = layer.open({
                    title: '设计问卷',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'question?id=' + arr[0],
                    end: function () {
                        table.reload('currentTableId');
                    }
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'preview') {
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var arr = [];
                for (index in data) {
                    arr.push(data[index].id);
                }
                if (arr.length != 1) {
                    layer.msg('请选择一张问卷进行预览', {time: 1000});
                    return;
                }
                // console.log(arr[0]);
                window.open("preview/" + arr[0]);
            } else if (obj.event === 'publish') {
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var arr = [];
                for (index in data) {
                    arr.push(data[index].id);
                }
                if (arr.length != 1) {
                    layer.msg('请选择一张问卷发布', {time: 1000});
                    return;
                }
                // console.log(arr[0]);
                $.ajax({
                    url: 'publish',
                    type: 'POST',
                    dataType: 'json',
                    data: 'id=' + arr[0],
                    success: function (data) {
                        // 提示成功后关闭
                        layer.msg(data.msg, {
                            time: 1500
                        }, function () {
                            parent.layer.close(index);
                            table.reload('currentTableId');
                        });
                    }
                });
            } else if (obj.event === 'queryDetail') {  // 监听统计操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var arr=[];
                for(index in data){
                    arr.push(data[index].id);
                }
                if(arr.length !=1){
                    layer.msg("请选择一行数据查看",{time:1000});
                    return;
                }
                if(data[0].url == "" || data[0].url == null){
                    layer.msg("请先发布再查看详情",{time:1000});
                    return;
                }
                window.open("queryDetail/"+arr[0]);
            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            // console.log(obj)
        });

    });
</script>

</body>
</html>