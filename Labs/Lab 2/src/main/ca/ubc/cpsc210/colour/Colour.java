package ca.ubc.cpsc210.colour;

// Represents a colour having a red, green and blue component,
// each of which is in the range [0, 255]
public class Colour {
    int red;
    int blue;
    int green;

    // EFFECTS: constructs the colour (r, g, b)
    Colour(int r, int g, int b) {
        red = r;
        blue = b;
        green = g;
    }

    // EFFECTS: returns true if this colour is on the grey scale,
    // false otherwise
    boolean isGreyScale() {
        return ((red == green) && (green == blue));
    }
    // EFFECTS: returns the hexadecimal representation of this colour
    String toHex() {
        int temp;
        temp = (red * 256 + green) * 256 + blue;
        return Integer.toHexString(temp);
    }
}
