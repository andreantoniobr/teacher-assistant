package swingInterface;

import java.awt.*;

public class CardLayoutOptions {
    private CardLayout cardLayout;
    private Container container;

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public void showCard(String cardName){
        cardLayout.show(container, cardName);
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
}
