package src.items;

import src.assets.AssetsLoader;

public class Card implements Item {
    public Card() {
        
    }

    public class CardPC {
        private BufferedImage[] images = AssetsLoader.loadCardPC();
    }

    public class CardMobile {
        private BufferedImage[] images = AssetsLoader.loadCardMobile();
    }
}

