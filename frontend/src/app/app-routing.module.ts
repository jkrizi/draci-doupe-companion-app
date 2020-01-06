import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {GeneratorComponent} from './features/generator/generator.component';
import {CalculatorComponent} from './features/calculator/calculator.component';
import {BattlegroundComponent} from './features/battleground/battleground.component';
import {ShopComponent} from './features/shop/shop.component';
import {InputComponent} from './features/input/input.component';
import {WeaponBlueprintComponent} from './forms/item-blueprints/weapon-blueprint/weapon-blueprint.component';
import {ArmorBlueprintComponent} from './forms/item-blueprints/armor-blueprint/armor-blueprint.component';
import {TreasureBlueprintComponent} from './forms/item-blueprints/treasure-blueprint/treasure-blueprint.component';
import {GoodsBlueprintComponent} from './forms/item-blueprints/goods-blueprint/goods-blueprint.component';
import {PersonBlueprintComponent} from './forms/character-blueprints/person-blueprint/person-blueprint.component';
import {BeastBlueprintComponent} from './forms/character-blueprints/beast-blueprint/beast-blueprint.component';
import {RaceComponent} from './forms/race/race.component';
import {SkillComponent} from './forms/skill/skill.component';
import {SpellComponent} from './forms/spell/spell.component';
import {SwordPlayMoveComponent} from './forms/sword-play-move/sword-play-move.component';

const appRoutes: Routes = [
  {path: 'generator', component: GeneratorComponent},
  {path: 'calculator', component: CalculatorComponent},
  {path: 'battleground', component: BattlegroundComponent},
  {path: 'shop', component: ShopComponent},
  {
    path: 'inputs', component: InputComponent, children: [
      {path: 'item', children: [
          {path: 'weapon', component: WeaponBlueprintComponent},
          {path: 'armor', component: ArmorBlueprintComponent},
          {path: 'treasure', component: TreasureBlueprintComponent},
          {path: 'goods', component: GoodsBlueprintComponent}
        ]},
      {
        path: 'character', children: [
          {path: 'person', component: PersonBlueprintComponent},
          {path: 'beast', component: BeastBlueprintComponent}
        ]
      },
      {path: 'race', component: RaceComponent},
      {path: 'skill', component: SkillComponent},
      {path: 'spell', component: SpellComponent},
      {path: 'swordplay', component: SwordPlayMoveComponent}
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
