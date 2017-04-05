<html>
<head>
    <meta charset="utf-8">
</head>
<body>
    <h2>登录</h2>
    <form id="formLogin" action="/SpringAOP/doLogin" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input name="name" type="text"></input></td>
            </tr>

            <tr>
                <td>密码:</td>
                <td><input name="password" type="password"></input></td>
            </tr>

            <tr>
                <td><input id="submit" type="submit" name="提交"></input></td>
            </tr>
        </table>
     </form>
</body>
</html>

<script type="text/javascript" src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
   /* $(function(){
        $("#submit").click(function(){
            document.getElementById("formLogin").submit();
            //$("#form").submit();
        });
    })*/
</script>