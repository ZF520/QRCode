package zeng;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadQRCode {
	public static void main(String[] args) {
		try {
			MultiFormatReader formatReader = new MultiFormatReader();
			
			File file = new File("E:/QRCode/img.png");
			
			BufferedImage image = ImageIO.read(file);
			
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			
			// �����ά��Ĳ���
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
			
			
			Result result = formatReader.decode(binaryBitmap,hints);
			
			System.out.println("�������:"+result.toString());
			System.out.println("��ά���ʽ����:"+result.getBarcodeFormat());
			System.out.println("��ά���ı�����"+result.getText());
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
