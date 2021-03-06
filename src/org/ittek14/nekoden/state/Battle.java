package org.ittek14.nekoden.state;

import org.ittek14.nekoden.Settings;
import org.ittek14.nekoden.battle.BattleAnime;
import org.ittek14.nekoden.battle.BattleEnemy;
import org.ittek14.nekoden.battle.Stats;
import org.ittek14.nekoden.enemy.TestEnemy;
import org.ittek14.nekoden.graphics.Sprite;
import org.ittek14.nekoden.gui.Button;
import org.ittek14.nekoden.gui.GUI;
import org.ittek14.nekoden.gui.ProgressBar;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Battle implements GameState {
  private long wait = 0;
	private GUI gui;
	private BattleAnime battleAnime;
	private BattleEnemy enemy;
	private Stats playerStats;
	private ProgressBar enemyHealthP, playerHealthP, playerMagicP;
	private Sprite playerSprite;
  private Sprite deadSprite;
	private Sprite attackSprite;
	private int turn = 0;
	
	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(int key, char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int key, char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonPressed(int controller, int button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonReleased(int controller, int button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownPressed(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownReleased(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftPressed(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftReleased(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightPressed(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightReleased(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpPressed(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpReleased(int controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		gui = new GUI();
		battleAnime = new BattleAnime();
		playerSprite = new Sprite("playerBig");
		deadSprite = new Sprite("dead");
		attackSprite = new Sprite("scratch");
		battleAnime.init(arg0, arg1);
		attackSprite.setLoop(false);
		
		//TEST ONLY
		enemy = new TestEnemy(new Vector2f(arg0.getWidth() / 2f, arg0.getHeight() / 2f - 160f - 48f));
		enemyHealthP = new ProgressBar(arg0, enemy.getStats().getHP(), 100f, 10f, new Vector2f(20, 20));
		playerHealthP = new ProgressBar(arg0, playerStats.getHP(), 100f, 10f, new Vector2f(20, 20));
		playerMagicP = new ProgressBar(arg0, playerStats.getMP(), 100f, 10f, new Vector2f(20, 20));
		enemyHealthP.setValue(enemy.getStats().getHP());
		
		playerHealthP.setValue(playerStats.getHP());
		playerMagicP.setValue(playerStats.getMP());
		gui.addWidget(enemyHealthP);
		gui.addWidget(playerHealthP);
		gui.addWidget(playerMagicP);
		
		gui.addWidget(new Button(arg0, new Vector2f(arg0.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 25f, arg0.getHeight() - battleAnime.getRegionSize().y - 100f + 30f), "Atk", new Vector2f(50, 30)){
			@Override
			public void onClick(int button) {
				if(turn == 0 && attackSprite.isFinished() && !playerStats.isDead()) {
					attackSprite.play();
					enemy.getStats().subtractHP(playerStats.getATK());
					turn = 1 - turn;
					attackSprite = new Sprite("scratch");
					wait = 2000;
				}
			}
		});
		/*gui.addWidget(new Button(arg0, new Vector2f(arg0.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 25f, arg0.getHeight() - battleAnime.getRegionSize().y - 100f + 65f), "Def", new Vector2f(50, 30)){
			@Override
			public void onClick(int button) {
				
			}
		});*/
		gui.addWidget(new Button(arg0, new Vector2f(arg0.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 25f, arg0.getHeight() - battleAnime.getRegionSize().y - 100f + 100f), "Bag", new Vector2f(50, 30)){
			@Override
			public void onClick(int button) {
				
			}
		});
		gui.addWidget(new Button(arg0, new Vector2f(arg0.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 700f - 35f, arg0.getHeight() - battleAnime.getRegionSize().y - 100f + 100f), "Run", new Vector2f(70, 30)){
			@Override
			public void onClick(int button) {
				if((turn == 0 && attackSprite.isFinished() && !playerStats.isDead()) || enemy.isDead()) {
					arg1.enterState(1);
				}
			}
		});
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
	}

	@Override
	public void leave(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		gui.clearWidgets(container);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		float scale = Settings.getScale();
		g.scale(scale, scale);
		g.translate(0f, 270 / 4 - 14f);
	
		battleAnime.renderBackground(container, game, g);
		
		enemy.render(container, game, g);
		if(playerStats.isDead())
		{
		  deadSprite.draw(container.getWidth() / 2f - 350f, container.getHeight() / 2f - 160 - 48f);
		}else{
		  playerSprite.draw(container.getWidth() / 2f - 350f, container.getHeight() / 2f - 160 - 48f);
		}
		
		if(!attackSprite.isFinished()) {
			if(turn == 1) {
				attackSprite.draw(container.getWidth() / 2f, container.getHeight() / 2f - 160f - 48f);
			} else if (turn == 0) {
				attackSprite.draw(container.getWidth() / 2f - 350f, container.getHeight() / 2f - 160 - 48f);
			}
		}
		
		g.resetTransform();
		g.setColor(Color.black);
		g.fillRect(0, 0, (container.getWidth() - 500 * scale) / 2, container.getHeight());
		g.fillRect(0, 0, container.getWidth(), (container.getHeight() - 270 * scale) / 2);
		g.fillRect(container.getWidth(), 0, -(container.getWidth() - 500 * scale) / 2, container.getHeight());
		g.fillRect(0, container.getHeight(), container.getWidth(), -(container.getHeight() - 270 * scale) / 2);
		
		battleAnime.render(container, game, g);
		
		gui.render(container, g);
		
		g.setColor(Color.black);
		g.drawString("Real Spooky Ghost", container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 700f - container.getDefaultFont().getWidth("Real Spooky Ghost") - 5, container.getHeight() - battleAnime.getRegionSize().y - 100f + 20f);
		enemyHealthP.setPosition(container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 700f - 140f, container.getHeight() - battleAnime.getRegionSize().y - 100f + 40f);
		
		g.drawString("The Hero", container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 70f, container.getHeight() - battleAnime.getRegionSize().y - 100f + 20f);
		g.drawString("HP: " + playerStats.getHP(), container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 70f, container.getHeight() - battleAnime.getRegionSize().y - 100f + 40f);
		g.drawString("MP: " + playerStats.getMP(), container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 70f, container.getHeight() - battleAnime.getRegionSize().y - 100f + 60f);
		g.drawString("ATK: " + playerStats.getATK(), container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 70f, container.getHeight() - battleAnime.getRegionSize().y - 100f + 80f);
		
		playerHealthP.setPosition(container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 150f, container.getHeight() - battleAnime.getRegionSize().y - 100f + 45f);
		playerMagicP.setPosition(container.getWidth() / 2f - battleAnime.getRegionSize().x / 2f + 150f, container.getHeight() - battleAnime.getRegionSize().y - 100f + 65f);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	  // TODO Auto-generated method stubws
		battleAnime.update(container, game, delta);
		gui.update(container, delta);
		enemy.update(container, game, delta);
		
		playerHealthP.setValue(playerStats.getHP());
		playerMagicP.setValue(playerStats.getMP());
		playerMagicP.setColor(Color.blue);
		if(playerHealthP.getValue() < playerHealthP.getMaxValue() / 2) {
			playerHealthP.setColor(Color.red);
		} else if(playerHealthP.getValue() < playerHealthP.getMaxValue() / 1.5f) {
			playerHealthP.setColor(Color.orange);
		} else {
			playerHealthP.setColor(Color.green);
		}
		
		enemyHealthP.setValue(enemy.getStats().getHP());
		if(enemyHealthP.getValue() < enemyHealthP.getMaxValue() / 2) {
			enemyHealthP.setColor(Color.red);
		} else if(enemyHealthP.getValue() < enemyHealthP.getMaxValue() / 1.5f) {
			enemyHealthP.setColor(Color.orange);
		} else {
			enemyHealthP.setColor(Color.green);
		}
		
		// CODE AFTER THIS IS NOT EXECUTED IF WAITING
    if(wait > 0){
      wait-=delta;
      return;
    }
    

    if(turn == 1 && attackSprite.isFinished() && !enemy.getStats().isDead()) {
      playerStats.subtractHP(enemy.getStats().getATK());
      turn = 1 - turn;
      attackSprite = new Sprite("flame");
      attackSprite.play();
      wait = 2000;
    }
 
    if(enemy.isDead())
    {
      game.enterState(1);
    }
	}

	public void setPlayerStats(Stats stats) {
		playerStats = stats;
	}
}
