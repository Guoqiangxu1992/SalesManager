/**
 商品销售额数据报表
 */
        function show1(basePath) {
        	 var arr1 = [];
        	  var arr2 = [];
            $.ajax({
            	
                type : "post",
                datatype:"json",
                url : basePath+'/deal/pdByNumData.do',
                success : function(data) {
                	
                	var str = eval(eval(data));
                     for(i=0;i<str.length;i++){
                         
                         arr1.push(str[i].name);
                         arr2.push(parseInt(str[i].money));
                         drewChart();
                     }
                     
                     
                },
                error : function(data) {
                    myChart.hideLoading();
                }
            })
         
    
        function drewChart(){
       
                // 基于准备好的dom，初始化echarts图表
                var myChart = echarts.init(document.getElementById('main')); 
               
                var options = {
                        title : {
                            text: '销售数量',
                        },
                        tooltip : {},
                        xAxis :
                            {
                        	     data:arr1
                             //   //data : '['+arr1+']',
                            } ,
                        yAxis :
                            {
                                type : 'value',
                            },
                        series : [
                            {
                                name:'销售数量',
                                type:'bar',
                                data:arr2
                                //data:'['+arr1+']'
                             
                            }]
                    };
                myChart.setOption(options);                
            } ;
        };
