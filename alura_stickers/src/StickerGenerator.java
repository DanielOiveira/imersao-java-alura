import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


public class StickerGenerator {

   public void createSticker(InputStream inputStream, String fileName) throws Exception {
        //Leitura da imagem
         // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        BufferedImage originalImage =  ImageIO.read(inputStream);

        //Criar nova imagem em memória com transparência e com tamanho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        //Copiar imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        //Configuração fonte
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
        graphics.setColor(Color.ORANGE);

        //Escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 200, newHeight - 100);

        //Escrever nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File("saida/" + fileName + ".png"));
    }
}
