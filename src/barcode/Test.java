package barcode;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "/Users/yuki/sample.png";
		try {
			// . 画像読み込み
			BufferedImage image = ImageIO.read(new File(filename));
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			if(true) System.out.println("unko");
			// . デコード
			Reader reader = new MultiFormatReader();
			Result result = reader.decode(bitmap);

			// . バーコードフォーマット
			BarcodeFormat format = result.getBarcodeFormat();

			// . バーコードコンテンツ（読み取り結果）
			String text = result.getText();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
