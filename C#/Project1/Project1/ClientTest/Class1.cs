using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project1.ClientTest
{
	class Class1
	{
		static void Main(String[] args) {
			//WebReference.SoapWebService soapWebService = new WebReference.SoapWebService();
			//String result = soapWebService.isMatch("421002198905121234");
			//Console.Write(result);
			Class2 client = new Class2();
			client.EndPoint = @"http://localhost:12345/rest/";

			client.Method = EnumHttpVerb.GET;
			string resultGet = client.HttpRequest("convert/%E5%B0%BC");
			Console.WriteLine("GET方式获取结果：" + resultGet);
		}	
	}
}
