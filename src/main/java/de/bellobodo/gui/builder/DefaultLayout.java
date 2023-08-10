package de.bellobodo.gui.builder;

import java.util.ArrayList;

public class DefaultLayout {

    /**
     * TODO
     * @param optionLength
     * @return
     */
    public ArrayList<Short> getSimpleGUIOptionLayout(final int optionLength) {
        ArrayList<Short> optionLayout = new ArrayList<>();

        switch (optionLength) {
            case 1:
                //13
                optionLayout.add((short) 13);
                break;
            case 2:
                //11,15
                optionLayout.add((short) 11);
                optionLayout.add((short) 15);
                break;
            case 3:
                //11,13,15
                for (short i = 11; i <= 15; i += 2) {
                    optionLayout.add(i);
                }
                break;
            case 4:
                //10,12,14,16
                for (short i = 10; i <= 16; i += 2) {
                    optionLayout.add(i);
                }
                break;
            case 5:
                //9,11,13,15,17
                for (short i = 9; i <= 17; i += 2) {
                    optionLayout.add(i);
                }
                break;
            case 6:
                //10,11,12,14,15,16
                for (short i = 10; i <= 16; i++) {
                    if (i == 13) continue;
                    optionLayout.add(i);
                }
                break;
            case 7:
                //10,11,12,13,14,15,16
                for (short i = 10; i <= 16; i++) {
                    optionLayout.add(i);
                }
                break;
            case 8:
                //9,10,11,12,14,15,16,17
                for (short i = 9; i <= 17; i++) {
                    if (i == 13) continue;
                    optionLayout.add(i);
                }
                break;
            case 9:
                //9,10,11,12,13,14,15,16,17
                for (short i = 9; i <= 17; i++) {
                    optionLayout.add(i);
                }
                break;
        }

        //TODO Add Support for the cases up to 54.

        return optionLayout;
    }

    /**
     * TODO
     * @param optionLength
     * @return
     */
    public int getSimpleGUISize(final int optionLength) {
        int size = 27;

        if (optionLength <= 27) {
            size = 27; // 3 * 9
        } else if (optionLength <= 36) {
            size = 36; //4 * 9
        } else if (optionLength <= 45) {
            size = 45; //5 * 9
        } else if (optionLength <= 54) {
            size = 54; //6 * 9
        }

        return size;
    }


}
