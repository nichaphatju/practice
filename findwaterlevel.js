function solution(A) {
    // Implement your solution here
    
    let wl = 0;

    for(i=1; i<A.length; i++){

        const leftBlocks = A.slice(0, i);
        const rightBlocks = A.slice(i, A.length);
        let highestL = Math.max(...leftBlocks);
        let highestR = Math.max(...rightBlocks);
        let lv = min(highestL, highestR) - A[i];
        wl = lv > wl ? lv : wl;
    }
        
    return wl;
    
}

function min(a, b){
    return a <= b ? a : b;
}
