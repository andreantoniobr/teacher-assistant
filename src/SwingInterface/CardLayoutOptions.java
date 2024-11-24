package SwingInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CardLayoutOptions {
    private CardLayout cardLayout;
    private Container container;

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
}
