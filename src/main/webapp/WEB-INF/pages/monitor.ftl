<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
    <h2>${user} Hello World!</h2>

    <table>
        <tr>
            <th>接口名称</th>
            <th>调用次数</th>
            <th>调用总时间</th>
        </tr>
        <#list serviceMap?keys as key>
            <tr>
                <td>${key}</td>
                <td>${serviceMap[key].count}</td>
                <td>${serviceMap[key].time}</td>
            </tr>
        </#list>
    </table>

    </body>
</html>
