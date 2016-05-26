/**
 * 
 * 区域销售额报表
 */

/*$(function (){
	show1()
})*/
        function show1(basePath) {
            $.ajax({
            	async:true, 
                type : "post",
                datatype:"json",
                url : basePath+'/deal/countMoneyByPrinvince1.do',
                success : function(data) {
                	var str = eval(eval(data));
                	 var money;
                	 var name;
                      s = [];
                     for(i = 0;i<str.length;i++){
                    	 money = str[i].value;
                    	 name=str[i].prinvince;
                    	 s.push({name:name,value:money}); 
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
                console.log(s);
                option = {
                	    title : {
                	        text: '区域销售额直观图',
                	        subtext: '',
                	        x:'center'
                	    },
                	    tooltip : {
                	        trigger: 'item'
                	    },
                	    legend: {
                	        orient: 'vertical',
                	        x:'left',
                	        data:['销售额']
                	    },
                	    dataRange: {
                	        x: 'left',
                	        y: 'bottom',
                	        splitList: [
                	            {start: 5400000000},
                	            {start: 4800000000, end: 5400000000},
                	            {start: 4200000000, end: 4800000000},
                	            {start: 3600000000, end: 4200000000},
                	            {start: 3000000000, end: 3600000000, label: '30亿 到 36亿'},
                	            {start: 10, end: 3000000000, label: '10到30亿', color: 'black'},
                	            {end: 10}
                	        ],
                	        color: ['#E0022B', '#E09107', '#A3E00B']
                	    },
                	    toolbox: {
                	        show: true,
                	        orient : 'vertical',
                	        x: 'right',
                	        y: 'center',
                	        feature : {
                	            mark : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    roamController: {
                	        show: true,
                	        x: 'right',
                	        mapTypeControl: {
                	            'china': true
                	        }
                	    },
                	    series : [
                	        {
                	            name: '销售额',
                	            type: 'map',
                	            mapType: 'china',
                	            roam: false,
                	            itemStyle:{
                	                normal:{
                	                    label:{
                	                        show:true,
                	                        textStyle: {
                	                           color: "rgb(249, 249, 249)"
                	                        }
                	                    }
                	                },
                	                emphasis:{label:{show:true}}
                	            },
                	            data:s
                	        }
                	    ]
                	};
                	                    
      
                myChart.setOption(option);                
            } ;
        };
