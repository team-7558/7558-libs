package libs.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class DPadButton extends Button {
    
    XboxController m_joystick;
    Direction m_direction;

    public DPadButton(XboxController joystick, Direction direction) {
        this.m_joystick = joystick;
        this.m_direction = direction;
    }

    public static enum Direction {
        UP(0), RIGHT(90), DOWN(180), LEFT(270);

        int direction;

        private Direction(int direction) {
            this.direction = direction;
        }
    }

    public boolean get() {
        int dPadValue = m_joystick.getPOV();
        return (dPadValue == m_direction.direction) || (dPadValue == (m_direction.direction + 45) % 360) || (dPadValue == (m_direction.direction + 315) % 360);
    }
}
