$(document).ready(function () {
    var lich = `<div class="row-calendar-check">
        <h3> Thứ 2</h3>
        <ul>
            <li class="buoihoc">
                <label class="bh" for="morning-calendar-2">Sáng</label>
                <input class="radio-calendar" id="morning-calendar-2" type="checkbox" name="sang_2" value="sang_2">
            </li>
            <li class="buoihoc">
                <label class="bh" for="afternoon-calendar-2">Chiều</label>
                <input class="radio-calendar" id="afternoon-calendar-2" type="checkbox" name="chieu_2" value="chieu_2">
            </li>
            <li class="buoihoc">
                <label class="bh" for="evening-calendar-2">Tối</label>
                <input class="radio-calendar" id="evening-calendar-2" type="checkbox" name="toi_2" value="toi_2">
            </li>
        </ul>
    </div>
    <div class="row-calendar-check">
        <h3>Thứ 3</h3>
        <ul>
            <li class="buoihoc">
                <label class="bh" for="morning-calendar-3">Sáng</label>
                <input class="radio-calendar" id="morning-calendar-3" type="checkbox" name="sang_3" value="sang_3">
            </li>
            <li class="buoihoc">
                <label class="bh" for="afternoon-calendar-3">Chiều</label>
                <input class="radio-calendar" id="afternoon-calendar-3" type="checkbox" name="chieu_3" value="chieu_3">
            </li>
            <li class="buoihoc">
                <label class="bh" for="evening-calendar-3">Tối</label>
                <input class="radio-calendar" id="evening-calendar-3" type="checkbox" name="toi_3" value="toi_3">
                </li>
            </ul>
            </div>
            <div class="row-calendar-check">
                <h3>Thứ 4</h3>
                <ul>
                    <li class="buoihoc">
                        <label class="bh" for="morning-calendar-4">Sáng</label>
                        <input class="radio-calendar" id="morning-calendar-4" type="checkbox" name="sang_4" value="sang_4">
                    </li>
                    <li class="buoihoc">
                        <label class="bh" for="afternoon-calendar-4">Chiều</label>
                        <input class="radio-calendar" id="afternoon-calendar-4" type="checkbox" name="chieu_4" value="chieu_4">
                    </li>
                    <li class="buoihoc">
                        <label class="bh" for="evening-calendar-4">Tối</label>
                        <input class="radio-calendar" id="evening-calendar-4" type="checkbox" name="toi_4" value="toi_4">
                    </li>
                </ul>
            </div>
            <div class="row-calendar-check">
                <h3>Thứ 5</h3>
                <ul>
                    <li class="buoihoc">
                        <label class="bh" for="morning-calendar-5">Sáng</label>
                        <input class="radio-calendar" id="morning-calendar-5" type="checkbox" name="sang_5" value="sang_5">
                    </li>
                    <li class="buoihoc">
                        <label class="bh" for="afternoon-calendar-5">Chiều</label>
                        <input class="radio-calendar" id="afternoon-calendar-5" type="checkbox" name="chieu_5" value="chieu_5">
                    </li>
                    <li class="buoihoc">
                        <label class="bh" for="evening-calendar-5">Tối</label>
                        <input class="radio-calendar" id="evening-calendar-5" type="checkbox" name="toi_5" value="toi_5">
                    </li>
                </ul>
            </div>
            <div class="row-calendar-check">
                <h3>Thứ 6</h3>
                <ul>
                    <li class="buoihoc">
                        <label class="bh" for="morning-calendar-6">Sáng</label>
                        <input class="radio-calendar" id="morning-calendar-6" type="checkbox" name="sang_6" value="sang_6">
                    </li>
                    <li class="buoihoc">
                        <label class="bh" for="afternoon-calendar-6">Chiều</label>
                        <input class="radio-calendar" id="afternoon-calendar-6" type="checkbox" name="chieu_6" value="chieu_6">
                    </li>
                    <li class="buoihoc">
                        <label class="bh" for="evening-calendar-6">Tối</label>
                        <input class="radio-calendar" id="evening-calendar-6" type="checkbox" name="toi_6" value="toi_6">
                    </li>
                </ul>
            </div>
            <div class="row-calendar-check">
                <h3>Thứ 7</h3>
                <ul>
                    <li class="buoihoc">
                        <label class="bh" for="morning-calendar-7">Sáng</label>
                        <input class="radio-calendar" id="morning-calendar-7" type="checkbox" name="sang_7" value="sang_7">
                    </li>
                    <li class="buoihoc">
                        <label class="bh" for="afternoon-calendar-7">Chiều</label>
                        <input class="radio-calendar" id="afternoon-calendar-7" type="checkbox" name="chieu_7" value="chieu_7">
                    </li>
                    <li class="buoihoc">
                        <label class="bh" for="evening-calendar-2">Tối</label>
                        <input class="radio-calendar" id="evening-calendar-7" type="checkbox" name="toi_7" value="toi_7">
                    </li>
                </ul>
            </div>
            <div class="row-calendar-check">
                <h3>Chủ nhật</h3>
                <ul>
                    <li class="buoihoc">
                        <label class="bh" for="morning-calendar-8">Sáng</label>
                        <input class="radio-calendar" id="morning-calendar-8" type="checkbox" name="sang_8" value="sang_8">
                    </li>
                    <li class="buoihoc">
                        <label class="bh" for="afternoon-calendar-8">Chiều</label>
                        <input class="radio-calendar" id="afternoon-calendar-8" type="checkbox" name="chieu_8" value="chieu_8">
                     </li>
                    <li class="buoihoc">
                        <label class="bh" for="evening-calendar-8">Tối</label>
                        <input class="radio-calendar" id="evening-calendar-8" type="checkbox" name="toi_8" value="toi_8">
                    </li>
                </ul>
            </div>`
    $(".schedule-detail").html(lich);
});