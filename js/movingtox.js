function solution(X, A) {
    // Implement your solution here
    // let second = -1;
    // let distance = X;
    let positions = new Set();
    for(let i=1; i<= X; i++){
        positions.add(i);
    }
    for(let i=0; i< A.length; i++){
        positions.delete(A[i]);
        if(positions.size === 0){
            return i;
        }
    }
    return -1;
}