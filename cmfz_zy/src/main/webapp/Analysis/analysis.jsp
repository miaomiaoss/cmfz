<%@page contentType="text/html; charset=utf-8" %>

<script src="${pageContext.request.contextPath}/js/echarts.js"></script>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">


    $(function () {
        $.post(
            "${pageContext.request.contextPath}/countUser",
            function (res) {
                //console.log(res[0]);

                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '持名法洲App活跃用户'
                    },
                    tooltip: {},
                    legend: {
                        data:['用户']
                    },
                    xAxis: {
                        data: ["一周","半个月","一年"]
                    },
                    yAxis: {
                        data:[1,2,3,4,5]
                    },
                    series: [{
                        name: '用户',
                        type: 'bar',
                        data: [res.countUser[0], res.countUser[1], res.countUser[2]]
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            },
            "json"
        );
    });


</script>
