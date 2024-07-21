package org.leetcode.weekly.july.week2;

class Robot {
    int position;
    int index;
    char direction;
    int health;

    public Robot(int position, int index, char direction, int health) {
        this.position = position;
        this.index = index;
        this.direction = direction;
        this.health = health;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "position=" + position +
                ", index=" + index +
                ", direction=" + direction +
                ", health=" + health +
                '}';
    }
}
