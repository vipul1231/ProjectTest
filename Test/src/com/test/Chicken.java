package com.test;

import java.util.concurrent.Callable;

interface IBird {
    Egg lay();
}

class Egg {
	
	IBird bird;
	int count = 0;

    public Egg(Callable<IBird> createBird) {
        try {
			bird = createBird.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public IBird hatch() throws Exception {
    	if(count == 0){
    		count++;
    		System.out.println("Hatched");
    		return bird;
    	}
    	else {
    		throw new IllegalStateException();
    	}
    }
}

class Elephant implements IBird{
	
	public Elephant() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Egg lay() {
		// TODO Auto-generated method stub
		return new Egg(new Callable<IBird>() {

			@Override
			public IBird call() throws Exception {
				// TODO Auto-generated method stub
				return new Elephant();
			}
		});
	}
	
}

class Chicken implements IBird{
    
	public Chicken() {
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        Egg egg = chicken.lay();
        try{
        	egg.hatch();
            egg.hatch();
        }
        catch(Exception e){
        	System.out.println(e);
        }
        
        
        Elephant elephant = new Elephant();
        Egg egg1 = elephant.lay();
        try{
        	egg1.hatch();
            egg1.hatch();
        }
        catch(Exception e){
        	System.out.println(e);
        }
        System.out.println(chicken instanceof IBird);
        System.out.println(elephant instanceof IBird);
    }

	@Override
	public Egg lay() {
		// TODO Auto-generated method stub
		return new Egg(new Callable<IBird>() {

			@Override
			public IBird call() throws Exception {
				// TODO Auto-generated method stub
				return new Chicken();
			}
		});
	}
}
