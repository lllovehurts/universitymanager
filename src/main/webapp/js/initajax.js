			function getXMLHttp(){
					var xmlHttp=false;
					if(window.XMLHttpRequest){
						xmlHttp=new XMLHttpRequest();
					}
					else if(window.ActiveXObject){
						try{
							xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");				
						}catch (e) {
							try{
								xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
							}catch (e) {
								window.alert("该浏览器不支持Ajax");
							}
						}
					}
					return xmlHttp;
				}