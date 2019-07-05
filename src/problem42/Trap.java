package problem42;

import java.util.Stack;

public class Trap {
    public int trap(int[] height) {

        boolean flag = false;
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int max_height = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            //System.out.println(stack);
            if(!flag){
                if(stack.empty()) {
                    stack.push(height[i]);
                    max_height = height[i];
                }
                else{
                    if(height[i] >= stack.peek()){
                        stack.pop();
                        stack.push(height[i]);
                        max_height = height[i];
                    }else{
                        stack.push(height[i]);
                        flag = true;
                    }
                }
            }else{
                if(height[i] <= stack.peek()) stack.push(height[i]);
                else{
                    int count = 0;
                    int min_Height = Math.min(max_height,height[i]);
                    while(true){
                        int peek = stack.peek();
                        if(height[i] > peek){
                            sum += min_Height - peek;
                            stack.pop();
                            count ++;
                            if(stack.empty()){
                                flag = false;
                                break;
                            }
                        }else if(height[i] == peek){
                            if(peek == max_height){
                                flag = false;
                            }else{
                                count ++;
                            }
                            stack.pop();
                            break;
                        }else{
                            break;
                        }
                    }

                    if(flag) {
                        for (int j = 0; j < count; j++) {
                            stack.push(height[i]);
                        }
                    }else{
                        max_height = height[i];
                    }
                    stack.push(height[i]);
                }
            }
        }

        return sum;

    }

    public static void main(String... args){
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Trap().trap(heights));
    }
}
