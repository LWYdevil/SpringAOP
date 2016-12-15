<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h2>SpringAOP</h2>
<table>
    <tr>
        <th>接口名称</th>
        <th>提交</th>
    </tr>

<#list services as service>
    <tr>
        <td>${service}</td>
        <td><a data-url="${service}" href="javascript:;">点击</a></td>
    </tr>
</#list>
</table>

<div id="print"></div>
</body>
</html>

<script type="text/javascript" src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
    $(function(){
        $("a").click(function(){


            var url = $(this).attr("data-url").replace(".","/");
            alert(url);

            $.ajax({
                type:"GET",
                url:"/helloword/"+url,
                success:function(data){
                    $("#print").html(data);
                },
                error:function(data){
                    console.log(data);
                }
            });
        });
    })
</script>