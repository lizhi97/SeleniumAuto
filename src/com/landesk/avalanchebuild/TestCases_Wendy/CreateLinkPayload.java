package com.landesk.avalanchebuild.TestCases_Wendy;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.landesk.AvalanchePageTestCasesBase;
import com.landesk.avalanche.PageObjects.MainPageAvalancheObj;
import com.landesk.avalanhchebuild.PageObjects_Wendy.CreateLinkPayloadObject;


public class CreateLinkPayload extends AvalanchePageTestCasesBase{
	private MainPageAvalancheObj mp; 
	private CreateLinkPayloadObject linkpayload;
	 
	@Parameters({"url","username","password"})
	@Test
	 //Creat link payload with Webview//
	 
	 public void LinkPayloadwithWebView(String url,String username,String password){
		     LoginAvalanchePage(url,username,password);
		     mp=new MainPageAvalancheObj(driver);
		     linkpayload= new CreateLinkPayloadObject(driver);
			 mp.clickProfileButton();
			 String[] LinkURL=new String [12];
			 LinkURL[0]="http://money.163.com/14/0725/15/A20PN1F200254IU4.html";
			 LinkURL[1]="http://weibo.com/guide/welcome";
			 LinkURL[2]="http://v.youku.com/v_show/id_XNDYxODg0NTM2.html";
			 LinkURL[3]="http://v.youku.com/v_show/id_XMjcwNjg5MTk2.html";
			 LinkURL[4]="http://money.163.com/14/0725/15/A20PN1F200254IU4.html";
			 LinkURL[5]="http://weibo.com/guide/welcome";
			 LinkURL[6]="http://v.youku.com/v_show/id_XNDYxODg0NTM2.html";
			 LinkURL[7]="http://v.youku.com/v_show/id_XMjcwNjg5MTk2.html";
			 LinkURL[8]="http://money.163.com/14/0725/15/A20PN1F200254IU4.html";
			 LinkURL[9]="http://weibo.com/guide/welcome";
			 LinkURL[10]="http://v.youku.com/v_show/id_XNDYxODg0NTM2.html";
			 LinkURL[11]="http://v.youku.com/v_show/id_XMjcwNjg5MTk2.html";
			 for (int i=0;i<LinkURL.length;i++)
			  {
			   linkpayload.clickNewPayload();
			   linkpayload.sleep(5000);
			   linkpayload.chooseLink();
			   linkpayload.InputPayloadName("payload"+i);
			   linkpayload.InputLabelName("LinkWebView"+i);
			   linkpayload.InputURL(LinkURL[i]);
			   linkpayload.LinkOptionsforiOS();
			   linkpayload.DeploymentMethod(1);
			   linkpayload.sleep(3000);
			   linkpayload.OpenWith(0);
			   linkpayload.SaveLinkPayload();
			  }
			 }
	
	 @Test
      //Create link payload with browser//
      public void LinkPayloadwithBrowser(){
		 String[] LinkURL1=new String [16];
		 LinkURL1[0]="http://news.sina.com.cn/c/z/xfbx2014/";
		 LinkURL1[1]="http://finance.sina.com.cn/chanjing/gsnews/20140725/031919813609.shtml";
		 LinkURL1[2]="http://eladies.sina.com.cn/";
		 LinkURL1[3]="http://v.youku.com/v_show/id_XMjcwNjg5MTk2.html";
		 LinkURL1[4]="http://news.sina.com.cn/c/z/xfbx2014/";
		 LinkURL1[5]="http://finance.sina.com.cn/chanjing/gsnews/20140725/031919813609.shtml";
		 LinkURL1[6]="http://eladies.sina.com.cn/";
		 LinkURL1[7]="http://v.youku.com/v_show/id_XMjcwNjg5MTk2.html";
		 LinkURL1[8]="http://news.sina.com.cn/c/z/xfbx2014/";
		 LinkURL1[9]="http://finance.sina.com.cn/chanjing/gsnews/20140725/031919813609.shtml";
		 LinkURL1[10]="http://eladies.sina.com.cn/";
		 LinkURL1[11]="http://v.youku.com/v_show/id_XMjcwNjg5MTk2.html";
		 LinkURL1[12]="http://news.sina.com.cn/c/z/xfbx2014/";
		 LinkURL1[13]="http://finance.sina.com.cn/chanjing/gsnews/20140725/031919813609.shtml";
		 LinkURL1[14]="http://eladies.sina.com.cn/";
		 LinkURL1[15]="http://v.youku.com/v_show/id_XMjcwNjg5MTk2.html";
		 for (int i=0;i<LinkURL1.length;i++){
		   linkpayload.clickNewPayload();
		   linkpayload.sleep(5000);
		   linkpayload.chooseLink();
		   linkpayload.InputPayloadName("payload1"+i);
		   linkpayload.InputLabelName("LinkBrowser"+i);
		   linkpayload.InputURL(LinkURL1[i]);
		   linkpayload.LinkOptionsforiOS();
		   linkpayload.DeploymentMethod(1);
		   linkpayload.sleep(3000);
		   linkpayload.OpenWith(1);
		   linkpayload.SaveLinkPayload();
		 }
	 }
	 


		
		 
 
	 
}
