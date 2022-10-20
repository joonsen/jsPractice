var dataSet = [44,55,66,77,88,99,88,77,88,99,44,55,77,88,77,99,88,66];

d3.select("#myGraph") //svg 요소 선택
.selectAll("rect")
.data(dataSet)
.enter()
.append("rect")
.attr("x",0)
.attr("y",function(d,i){
    return i * 25;
})
.attr("width",function(d,i){
    return d + "px";
})
.attr("height","20px")