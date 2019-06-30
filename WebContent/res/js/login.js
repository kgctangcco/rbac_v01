$(document).ready(function() {
    let $url = 'http://172.16.1.104:8080/rbac_v01';
    layui.use(['layer', 'form', 'laydate'], function() {
        var layer = layui.layer,
            laydate = layui.laydate,
            form = layui.form;
        form.on('submit(loginBtu)', function(data) {
            $.ajax({
                url: $url + '/front/user.action?methodName=login',
                method: 'post',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data.field),
                dataType: 'JSON',
                success: function(rs) {
                    window.console.log(rs)
                },
            })
            return false;
        });
    });
});