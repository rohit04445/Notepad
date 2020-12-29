
public class font_types {
    public static String Selected_font_ch = "Times New Roman";
   public static String[]font_ch={"Abadi MT Condensed Extra Bold", "Abadi MT Condensed Light",
           "Academy Engraved LET", "Al Bayan", "American Typewriter", "Andale Mono",
           "Apple Casual", "Apple Chancery", "Apple LiGothic", "Apple LiSung", "Apple Symbols",
           "AppleGothic", "AppleMyungjo",
           "Arial", "Arial Black", "Arial Hebrew", "Arial Narrow", "Arial Rounded MT Bold",
           "Ayuthaya", "Baghdad" , "Bank Gothic", "Baskerville" ,
           "Baskerville Old Face", "Batang", "Bauhaus 93", "Bell MT", "Bernard MT Condensed",
           "BiauKai", "Big Caslon", "Bitstream Vera Sans", "Bitstream Vera Sans Mono",
           "Bitstream Vera Serif", "Blackmoor LET", "BlairMdITC TT", "Bodoni Ornaments ITC TT",
           "Bodoni SvtyTwo ITC TT", "Bodoni SvtyTwo OS ITC TT",
           "Bodoni SvtyTwo SC ITC TT", "Book Antiqua", "Bookman Old Style", "Bordeaux Roman Bold LET",
           "Bradley Hand ITC TT", "Braggadocio", "Britannic Bold", "Brush Script MT", "Calisto MT",
           "Century", "Century Gothic", "Century Schoolbook", "Chalkboard", "Charcoal CY",
           "Cochin", "Colonna MT", "Comic Sans MS", "Cooper Black", "Copperplate", "Copperplate Gothic Bold",
           "Copperplate Gothic Light", "Corsiva Hebrew", "Courier", "Courier New", "Cracked", "Curlz MT",
           "DecoType Naskh", "Desdemona", "Devanagari MT", "Dialog", "DialogInput", "Didot", "Edwardian Script ITC",
           "Engravers MT", "Euphemia UCAS", "Eurostile", "Footlight MT Light", "Futura", "Garamond", "GB18030 Bitmap",
           "Geeza Pro", "Geneva", "Geneva CY", "Georgia", "Gill Sans", "Gill Sans Ultra Bold", "Gloucester MT Extra " +
           "Condensed", "Goudy Old Style", "Gujarati MT", "Gulim", "Gurmukhi MT", "Haettenschweiler",
           "Handwriting - Dakota", "Harrington", "Hei", "Helvetica", "Helvetica CY", "Helvetica Neue", "Herculanum",
           "Hiragino Kaku Gothic Pro", "Hiragino Kaku Gothic Std", "Hiragino Maru Gothic Pro", "Hiragino Mincho Pro",
           "Hoefler Text", "Impact", "Imprint MT Shadow", "InaiMathi", "Jazz LET", "Kai", "Kino MT",
           "Krungthep", "KufiStandardGK", "LiHei Pro", "LiSong Pro", "Lucida Blackletter",
           "Lucida Bright", "Lucida Calligraphy", "Lucida Fax", "Lucida Grande", "Lucida Handwriting", "Lucida Sans",
           "Lucida Sans Typewriter", "Marker Felt", "Matura MT Script Capitals", "Mistral",
           "Modern No. 20", "Mona Lisa Solid ITC TT", "Monaco", "Monospaced", "Monotype Corsiva", "Monotype Sorts",
           "MS Gothic", "MS Mincho", "MS PGothic", "MS PMincho", "Mshtakan", "MT Extra","Nadeem",
           "New Peninim MT", "News Gothic MT", "Onyx", "OpenSymbol", "Optima", "Osaka", "Palatino",
           "Papyrus", "Party LET", "Perpetua Titling MT", "Plantagenet Cherokee",
           "Playbill", "PMingLiU", "PortagoITC TT", "Princetown LET", "Raanana", "Rockwell",
           "Rockwell Extra Bold", "SansSerif", "Santa Fe LET", "Sathu", "Savoye LET", "SchoolHouse Cursive B",
           "SchoolHouse Printed A", "Serif", "Silom", "SimSun", "Skia", "Snell Roundhand",
           "Stencil", "STFangsong", "STHeiti", "STKaiti", "Stone Sans ITC TT",
           "Stone Sans Sem ITC TT", "STSong", "Symbol", "Synchro LET", "Tahoma", "Thonburi", "Times",
           "Times New Roman", "Trebuchet MS", "Type Embellishments One LET", "Verdana", "Webdings",
           "Wide Latin", "Wingdings", "Wingdings 2", "Wingdings 3", "Zapf Dingbats", "Zapfino"};
   public static String[] font_size={"14","16","18","20","22","24","26","28","30","32","34"};
   public static String selected_font_size="20";
   public static String[] font_b={"PLAIN","BOLD","ITALIC"};
   public static String selected_font_b="PLAIN";

    public static void setSelected_font_ch(String selected_font_ch) {
        Selected_font_ch = selected_font_ch;
    }

    public static void setSelected_font_size(String selected_font_size) {
        font_types.selected_font_size = selected_font_size;
    }

    public static void setSelected_font_b(String selected_font_b) {
        font_types.selected_font_b = selected_font_b;
    }

    public static String getSelected_font_ch() {
        return Selected_font_ch;
    }

    public static int getSelected_font_size() {
        return Integer.parseInt(selected_font_size);
    }

    public static int getSelected_font_b() {

        switch (selected_font_b){
            case "PLAIN":return 0;
            case "ITALIC":return 2;
            case "BOLD":return 1;

        }
        return 0;
    }
}

