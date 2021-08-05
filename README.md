# Shogi Java

Shogi is a game similar to chess. You can find the rules here:

https://en.wikipedia.org/wiki/Shogi

### Features

- Pieces movement
- Promoted Pieces movement
- Promotions implemented including forced promotions 
    - Knights must be promoted when reaching the last two ranks
    - Lances and Pawns must be promoted when reaching the last rank
- Console game interaction
- Unit Tests for all piece movements including promoted pieces
- Pieces captures implemented
- Pieces drops (placing a captured piece on the board) implemented including drop rules 
    - Pawns cannot be dropped on a column with an existing non promoted pawn of the same color
    - Pawns cannot be dropped to give instant checkmate
    - Knights cannot be dropped on the last two ranks
    - Lances and Pawns cannot be dropped on the last rank
- Checkmate detection implemented 
    - Including checkmate prevention by moving or dropping a piece

