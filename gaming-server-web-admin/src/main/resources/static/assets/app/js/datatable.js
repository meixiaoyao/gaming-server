var DataTable = function(){
    /**
     * 初始化 HTML 表格
     * @param id
     */
    var handlerInitHtmlTable = function(id){
        var datatable = $('#' + id).mDatatable({
            data: {
                saveState: {cookie: false}
            },
            sortable: false,
            pagination: false
        });
    };
    var handlerInitAjaxTable = function (id, url, columns) {
        var datatable = $('#'+id).mDatatable({
            // 国际化
            translate:{
                records:{
                    processing:"加载中，请稍后...",
                    noRecords:'没有任何记录'
                },

                toolbar:{
                    pagination:{
                        items:{
                            default:{
                                first: '首页',
                                prev: '上一页',
                                next: '下一页',
                                last: '尾页',
                                more: '更多',
                                input: '页数',
                                select: '显示笔数'
                            },
                            info: '显示第 {{start}} - {{end}} 条记录，总共 {{total}} 条记录'
                        }
                    }
                }
            },

            // 定义数据源
            data:{
                type: 'remote',
                source:{
                    read:{
                        method: 'POST',
                        url: url,
                        map: function (raw) {
                            var dataSet = raw;
                            if(typeof raw.data !== 'undefined'){
                                dataSet = raw.data;
                            }
                            return dataSet;
                        }
                    }
                },
                pageSize: 10,
                serverPaging: true,
                serverFiltering: true,
                serverSorting: true
            },

            // 开启分页
             pagination: true,
            toolbar:{
                items:{
                    pagination:{
                        pageSizeSelect:[10, 20, 50]
                    }
                }
            },

            // 定义数据列
            columns: columns
        });
    };

    return{
        initHtmlTable:function (id) {
            handlerInitHtmlTable(id);
        },

        initAjTable: function (id, url, columns) {
            handlerInitAjaxTable(id, url, columns);
        }
    }
}();
