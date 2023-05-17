extends CharacterBody2D

var grafity = 500
var JUMP_FORCE = -500
var MOVE_SPEED = 200


func _physics_process(delta):
	velocity.y += grafity * delta
	var input_direction = Input.get_axis("left", "right")
	
	if Input.is_action_just_pressed("jump") and is_on_floor():
		velocity.y = JUMP_FORCE
		
	if input_direction:
		velocity.x = input_direction * MOVE_SPEED
	else:
		velocity.x = move_toward(velocity.x,0,MOVE_SPEED)

	move_and_slide()
