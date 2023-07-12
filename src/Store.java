import java.util.*;

public class Store {
   private String name;
   private Set <Salesman> salesmanList;
   private List<Product> productList;
   private Map<Integer, Set<Product>> bonusProductsByDay;

   public Store(Set<Salesman> salesmanList, List<Product> productList) {
      this.salesmanList = salesmanList;
      this.productList = productList;
      Random random = new Random();
      Set<Product> bonusProducts = new HashSet<>();
      for (int i = 0; i < 8; i++) {
         int index =random.nextInt(this.productList.size());
         int ind = random.nextInt(this.productList.size());
         this.bonusProductsByDay.put(i,bonusProducts);

      }
   }

   private int randomNumber(){
      Random random = new Random();
      int answer=0;
      if (productList.stream().count()>3){
         answer=random.nextInt((int) productList.stream().count());
      }
      return answer;
   }
}
