const { createApp } = Vue

createApp({
    data() {
        return {
            inquiry: {
                memberId: null
                ,categoryId: null
            }
        }
    },
    computed: {
    },
    methods: {
        goList() {
            location.href = `/inquiry/list`;
        },

        async regInquiry() {
            let requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(this.inquiry),
            };

            console.log(this.inquiry);
            console.log(requestOptions);

            await fetch(`/api/inquiries`, requestOptions);

            this.goList();
        },
    },
    async created() {
        let response = await fetch(`/api/inquiries/list`);
        let list = await response.json();
        this.inquiry.memberId = list[0].memberId;
    }
}).mount('main');


// ============================dropdown=========================
window.addEventListener("load", function (){
    let section = document.querySelector("#category");        //드롭다운 전체 영역
    let btn = section.querySelector(".dropdown-btn");           //드롭다운 버튼
    let list = section.querySelector(".dropdown-list");         //드롭다운 리스트
    let input = section.querySelector("input[type='hidden']");                //드롭다운 input(hidden)

//드롭다운 버튼 선택 했을 때(리스트 숨겼다 보여졌다)
    btn.onclick = function () {

        list.classList.toggle("active");
    }

//드롭다운 리스트에서 옵션 하나 선택 했을 때
    list.onclick = function (e) {

        //선택한 옵션 값 보여주기
        btn.textContent = e.target.textContent;

        //input에 값 넣어주기
        input.value = e.target.dataset.id  // 필요한 값 dataset으로 꺼내옴

        const app = document.querySelector('main').__vue_app__;
        app._instance.proxy.inquiry.categoryId = e.target.dataset.id;



        //리스트 숨기기
        list.classList.remove("active");
    }
});

