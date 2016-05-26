/**
 * 
 * 产品销售额报表
 */

/*$(function (){
	show1()
})*/
        function show1(basePath) {
	   //alert(basePath);
        	 var arr12 = [];
        	  var arr13 = [];
        	  var arr14 = [];
        	  var arr15 = [];
            $.ajax({
            	async:true, 
                type : "post",
                datatype:"json",
                url : basePath+'/deal/countMoneyByMonth1.do',
                success : function(data) {
                	
                	var str = eval(eval(data));
                     for(i=0;i<str.length;i++){
                    	if(i<12){
                             arr12.push(parseInt(str[i].money));
                    	}else if(i<24){
                    		arr13.push(parseInt(str[i].money));
                    	}else if(i<36){
                    		arr14.push(parseInt(str[i].money));
                    	}else{
                    		arr15.push(parseInt(str[i].money));
                    	}
                        
                     }
                     drewChart();
                     
                },
                error : function(data) {
                    myChart.hideLoading();
                }
            })
         
    
        function drewChart(){
       
                // 基于准备好的dom，初始化echarts图表
                var myChart = echarts.init(document.getElementById('main')); 
               
                
                option = {
                		  title : {
                              text: '年度销售曲线图',
                              
                          },
                	    tooltip : {
                	        trigger: 'axis'
                	    },
                	    legend: {
                	        data:['2012年度','2013年度','2014年度','2015年度']
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    calculable : true,
                	    xAxis : [
                	        {
                	            type : 'category',
                	            boundaryGap : false,
                	            data :['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
                	        }
                	    ],
                	    yAxis : [
                	        {
                	            type : 'value'
                	        }
                	    ],
                	    series : [
                	              {
                	                  name:'2012年度',
                	                  type:'line',
                	                  stack: '总量',
                	                  data:arr12
                	              },
                	              {
                	                  name:'2013年度',
                	                  type:'line',
                	                  stack: '总量',
                	                  data:arr13
                	              },
                	              {
                	                  name:'2014年度',
                	                  type:'line',
                	                  stack: '总量',
                	                  data:arr14
                	              },
                	              {
                	                  name:'2015年度',
                	                  type:'line',
                	                  stack: '总量',
                	                  data:arr15
                	              }
                	          ]
                	};
                	                    
               /* var options = {
                        title : {
                            text: '销售额前十名',
                            
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
                                name:'销售额',
                                type:'bar',
                                data:arr2
                                //data:'['+arr1+']'
                             
                            }]
                    };*/
                myChart.setOption(option);                
            } ;
        };
