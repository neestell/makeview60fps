# Make your custom view 60fps
There is an issue with 2D graphic to draw on Canvas.
You can use onDraw() method to obtain a Canvas and draw on it or lockCanvas() and post frames using SurfaceView or TextureView.
But how to decide which one you should choose to solve a task?
This example demonstrates a common interface to interact with 3-types of View, turn on/off Hardware Acceleration or count of shapes to draw.
