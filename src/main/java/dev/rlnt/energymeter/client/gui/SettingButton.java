package dev.rlnt.energymeter.client.gui;

import dev.rlnt.energymeter.network.PacketHandler;
import dev.rlnt.energymeter.network.SettingUpdatePacket;
import dev.rlnt.energymeter.util.Tooltip;
import dev.rlnt.energymeter.util.TypeEnums.SETTING;

public class SettingButton extends LabelButton {

    private static final int TEXTURE_WIDTH = 28;
    private static final int TEXTURE_HEIGHT = 19;
    private final SETTING setting;
    private final Tooltip tooltip;

    SettingButton(MeterScreen screen, int pX, int pY, SETTING setting, String label) {
        super(screen, pX, pY, TEXTURE_WIDTH, TEXTURE_HEIGHT, label);
        this.setting = setting;
        tooltip = setupTooltip();
    }

    @Override
    protected void clickHandler() {
        PacketHandler.CHANNEL.sendToServer(new SettingUpdatePacket(setting));
    }

    @Override
    protected String getTexture() {
        return "setting";
    }

    @Override
    protected int getTextureWidth() {
        return TEXTURE_WIDTH;
    }

    @Override
    protected int getTextureHeight() {
        return TEXTURE_HEIGHT;
    }

    @Override
    protected Tooltip setupTooltip() {
        return Tooltip
            .builder()
            // header
            .addHeader(setting.toString().toLowerCase())
            .addBlankLine()
            // action
            .addClickAction("action_3");
    }

    @Override
    protected Tooltip getTooltip() {
        return tooltip;
    }
}
