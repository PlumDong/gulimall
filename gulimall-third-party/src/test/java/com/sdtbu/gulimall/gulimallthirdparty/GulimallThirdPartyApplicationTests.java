package com.sdtbu.gulimall.gulimallthirdparty;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
class GulimallThirdPartyApplicationTests {

	//@Resource
	OSSClient ossClient;

//	@Autowired
//	OSS ossClient;

	@Test
	public void testUpaload() throws FileNotFoundException {
//		// yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
//		String endpoint = "oss-cn-shanghai.aliyuncs.com";
//		// 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//		String accessKeyId = "LTAI5t5kdQ88dggD5Jj4C9BP";
//		String accessKeySecret = "UUyDLxjoJzrTKvq0WXHEd1NbXElQdx";

		// 创建OSSClient实例。
		//OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

		// 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
		InputStream inputStream = new FileInputStream("C:\\Users\\Administrator\\Pictures\\Control4k.jpg");
		// 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
		ossClient.putObject("goosemall", "exampledir/Control33.jpg", inputStream);

		// 关闭OSSClient。
		ossClient.shutdown();

	}

}
