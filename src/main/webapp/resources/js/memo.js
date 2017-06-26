/**
 * 
 */

	function memoView(num) {
		$.get("memoView/"+num, function(data) {
			alert(data.writer);
		});
	}


	function memoWrite(writer, contents) {
		$.ajax({
			url:"memoWrite",
			type:"post",
			data:{
				writer: writer,
				contents: contents
			},
			success:function(data){
				var result = "<table>";
				
				$(data).each(function() {
					result = result+"<tr>";
					result = result+"<td>"+this.num+"</td>";
					result = result+"<td>"+this.contents+"</td>";
					result = result+"<td>"+this.writer+"</td>";
					result = result+"<td>"+this.regdate+"</td>";
					result = result+"</tr>";
				});
				result = result +"</table>";
				$("#result").html(result);
			}
		})
	}
	
	function getList(curPage, find, search) {
		
		$.ajax({
			url:"getMemoList/"+curPage+"/"+find+"/"+search,
			type: "GET",
			
			success:function(data){
				
				
				var result = "<table>";
				
				$(data).each(function() {
					result = result+"<tr>";
					result = result+"<td>"+this.num+"</td>";
					result = result+"<td>"+this.contents+"</td>";
					result = result+"<td>"+this.writer+"</td>";
					result = result+"<td>"+this.regdate+"</td>";
					result = result+"</tr>";
				});
				result = result +"</table>";
				$("#result").html(result);
				
			}
		});
		/* $.get("URL?name=value", function(data) {});
		$.post("URL",{name=value}, function(data){});
		$.ajax({
			url:,
			type:,
			data:{},
			success:function(data){
				
			}
		});
		$("#result").load */
	}