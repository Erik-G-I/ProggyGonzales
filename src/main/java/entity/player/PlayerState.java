package entity.player;

/**
 * Enum for each player state
 * Each power up will set a PlayerState with corresponding abilities.
 * Default for player 1 is NORMAL
 * Default for player 2 is INVISIBLE
 */
public enum PlayerState {
    NORMAL,
    INVISIBLE, 
    FASTER,
    VOI
}
