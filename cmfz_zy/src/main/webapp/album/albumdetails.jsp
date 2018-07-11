<script type="text/javascript">
    $(function () {

        $('#albumDetailTable').datagrid({

            //href:"${pageContext.request.contextPath}/album/album.jsp",
            columns:[[
                {field:'name',title:'Name'},
                {field:'brodecast',title:'Brodecast',width:100},
                {field:'author',title:'Author',width:100,align:'right'},
                {field:'count',title:'Count',width:100,align:'right'},
                {field:'coverpicture',title:'Cover Picture',width:100,align:'right'},
                {field:'score',title:'Score',width:100,align:'right'},
                {field:'createtime',title:'Create Time',width:100,align:'right'},
                {field:'status',title:'Status',width:100,align:'right'}
            ]]

        });

        $('#albumDetailTable').datagrid({
            data: [
                {name:album.name, brodecast:album.brodecast, author:album.author, count: album.count, coverpicture: album.coverpicture,
                    score: album.score, createtime: album.createtime, status: album.status
                }
            ]
        });


    });

</script>

<table id="albumDetailTable">

</table>
